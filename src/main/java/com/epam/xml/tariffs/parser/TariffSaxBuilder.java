package com.epam.xml.tariffs.parser;

import com.epam.xml.tariffs.entity.Tariff;
import com.epam.xml.tariffs.handler.TariffErrorHandler;
import com.epam.xml.tariffs.handler.TariffHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class TariffSaxBuilder {
    private static Logger logger = LogManager.getLogger();
    private Set<Tariff> tariffs;
    private TariffHandler handler = new TariffHandler();
    private XMLReader reader;

    public TariffSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace(); // log
        }
        reader.setErrorHandler(new TariffErrorHandler());
        reader.setContentHandler(handler);
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }
    public void buildSetTariffs(String filename){
        try {
            reader.parse(filename);
        }
        catch (IOException | SAXException e){
            logger.fatal(e.getMessage());
        }
        tariffs = handler.getTariffs();
    }
}
