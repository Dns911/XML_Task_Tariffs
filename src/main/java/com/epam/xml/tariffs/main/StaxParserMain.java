package com.epam.xml.tariffs.main;

import com.epam.xml.tariffs.parser.TariffSTaxBuilder;

public class StaxParserMain {
    public static void main(String[] args) {
        TariffSTaxBuilder tariffSTaxBuilder = new TariffSTaxBuilder();
        tariffSTaxBuilder.buildSetTariffs("data/tariffs.xml");
        System.out.println(tariffSTaxBuilder.getTariffs());
    }
}
