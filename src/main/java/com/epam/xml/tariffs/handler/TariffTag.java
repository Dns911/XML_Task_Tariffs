package com.epam.xml.tariffs.handler;

public enum TariffTag {
    TARIFFS("tariffs"),
    NAME("name"),
    OPERATOR_NAME("operator name"),
    TARIFF("tariff"),
    PAYROLL("payroll"),
    INNERCALLS("inner calls"),
    OUTERCALLS("outer calls"),
    FIXEDLINECALLS("fixed line calls"),
    SMSPRICE("SMS price"),
    FAVORITENUM("favorite number"),
    TARIFFICATION("tariffication"),
    STARTPAY("start pay"),
    CALLPRICE("call price"),
    TARIFFPARAMETER("tariff parameter");

    private String value;

    TariffTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
