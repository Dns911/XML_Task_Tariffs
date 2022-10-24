package com.epam.xml.tariffs.parser;

import com.epam.xml.tariffs.entity.Tariff;
import com.epam.xml.tariffs.handler.TariffTag;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class TariffSTaxBuilder {
    private Set<Tariff> tariffs;
    private XMLInputFactory inputFactory;

    public TariffSTaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        tariffs = new HashSet<Tariff>();
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public void buildSetTariffs(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
// StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(TariffTag.TARIFF.getValue())) {
                        Tariff tariff = buildTariff(reader);
                        tariffs.add(tariff);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Tariff buildTariff(XMLStreamReader reader) throws XMLStreamException {
        Tariff tariff = new Tariff();
        tariff.setUniqueName(reader.getAttributeValue(null, TariffTag.UNIQUE_NAME.getValue()));
        tariff.setName(reader.getAttributeValue(null, TariffTag.NAME.getValue()));
        tariff.setOperatorName(reader.getAttributeValue(null, TariffTag.OPERATOR_NAME.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffTag.valueOf(name.toUpperCase())) {
                        case START_DATE -> tariff.setStartDate(Instant.parse(getXMLText(reader) + "T00:00:00.00Z"));
                        case PAYROLL -> tariff.setPayroll(Double.parseDouble(getXMLText(reader)));
                        case CALL_PRICE -> tariff.setCallPrice(getXMLCallPrice(reader));
                        case SMS_PRICE -> tariff.setSmsPrice(Double.parseDouble(getXMLText(reader)));
                        case TARIFF_PARAMETER -> tariff.setTariffParameter(getXMLTariffParameter(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffTag.valueOf(name.toUpperCase()) == TariffTag.TARIFF) {
                        return tariff;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <tariffs>");
    }

    private Tariff.CallPrice getXMLCallPrice(XMLStreamReader reader) throws XMLStreamException {
        Tariff.CallPrice callPrice = new Tariff().new CallPrice();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffTag.valueOf(name.toUpperCase())) {
                        case INNER_CALLS -> callPrice.setInnerCalls(Double.parseDouble(getXMLText(reader)));
                        case OUTER_CALLS -> callPrice.setOuterCalls(Double.parseDouble(getXMLText(reader)));
                        case FIXED_LINE_CALLS -> callPrice.setFixedLineCalls(Double.parseDouble(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffTag.valueOf(name.toUpperCase()) == TariffTag.CALL_PRICE) {
                        return callPrice;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <call_price>");
    }

    private Tariff.TariffParameter getXMLTariffParameter(XMLStreamReader reader) throws XMLStreamException {
        Tariff.TariffParameter tariffParameter = new Tariff().new TariffParameter();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffTag.valueOf(name.toUpperCase())) {
                        case FAVORITE_NUM -> tariffParameter.setFavoriteNum(Integer.parseInt(getXMLText(reader)));
                        case TARIFFICATION -> tariffParameter.setTariffication(Integer.parseInt(getXMLText(reader)));
                        case START_PAY -> tariffParameter.setStartPay(Double.parseDouble(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffTag.valueOf(name.toUpperCase()) == TariffTag.TARIFF_PARAMETER) {
                        return tariffParameter;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <call_price>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
