package com.epam.xml.tariffs.parser;

import com.epam.xml.tariffs.entity.Tariff;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class TariffDomBuilder {
    private static Logger logger = LogManager.getLogger();
    private Set<Tariff> tariffs;
    private DocumentBuilder docBuilder;
    private static final String ELEMENT_TARIFF = "tariff";

    public TariffDomBuilder() {

        tariffs = new HashSet<Tariff>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public void buildSetStudents(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList tariffList = root.getElementsByTagName(ELEMENT_TARIFF);
            for (int i = 0; i < tariffList.getLength(); i++) {
                Element tariffElement = (Element) tariffList.item(i);
                Tariff tariff = buildTariff(tariffElement);
                tariffs.add(tariff);
            }
        } catch (IOException | SAXException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    private Tariff buildTariff(Element tariffElement) {
        Tariff tariff = new Tariff();
        tariff.setName(tariffElement.getAttribute("name"));
        tariff.setOperatorName(tariffElement.getAttribute("operator_Name"));
        tariff.setUniqueName(tariffElement.getAttribute("unique_Name"));
        tariff.setStartDate(Instant.parse(getElementTextContent(tariffElement, "start_Date") + "T00:00:00.00Z"));
        tariff.setPayroll(Double.parseDouble(getElementTextContent(tariffElement, "payroll")));

        Tariff.CallPrice callPrice = tariff.getCallPrice();
        Element callPriceElement = (Element) tariffElement.getElementsByTagName("Call_Price").item(0);
        callPrice.setInnerCalls(Double.parseDouble(getElementTextContent(tariffElement, "inner_Calls")));
        callPrice.setOuterCalls(Double.parseDouble(getElementTextContent(tariffElement, "outer_Calls")));
        callPrice.setFixedLineCalls(Double.parseDouble(getElementTextContent(tariffElement, "fixed_Line_Calls")));

        tariff.setSmsPrice(Double.parseDouble(getElementTextContent(tariffElement, "sms_Price")));

        Tariff.TariffParameter tariffParameter = tariff.getTariffParameter();
        Element tariffParemeterElement = (Element) tariffElement.getElementsByTagName("Tariff_Parameter").item(0);
        tariffParameter.setFavoriteNum(Integer.parseInt(getElementTextContent(tariffElement, "favorite_Num")));
        tariffParameter.setTariffication(Integer.parseInt(getElementTextContent(tariffElement, "tariffication")));
        tariffParameter.setStartPay(Double.parseDouble(getElementTextContent(tariffElement, "start_Pay")));
        return tariff;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
