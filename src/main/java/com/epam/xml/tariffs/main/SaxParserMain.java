package com.epam.xml.tariffs.main;

import com.epam.xml.tariffs.parser.TariffSaxBuilder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaxParserMain {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        TariffSaxBuilder tariffSaxBuilder = new TariffSaxBuilder();
        tariffSaxBuilder.buildSetTariffs("data/tariffs.xml");
        System.out.println(tariffSaxBuilder.getTariffs());
    }
}
