package com.epam.xml.tariffs.main;

import com.epam.xml.tariffs.parser.TariffDomBuilder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DomMain {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        TariffDomBuilder domBuilder = new TariffDomBuilder();
        domBuilder.buildSetStudents("data/tariffs.xml");
        System.out.println(domBuilder.getTariffs().toString());
    }
}
