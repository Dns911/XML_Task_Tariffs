package com.epam.xml.tariffs.handler;

public enum TariffEnum {
    TARIFFS("tariffs"),
    NAME("name"),
    OPERATOR_NAME("operator name"),
    TARIFF("tariff"),
    PAYROLL("payroll"),
    INNER_CALLS("inner calls"),
    OUTER_CALLS("outer calls"),
    FIXED_LINE_CALLS("fixed line calls"),
    SMS_PRICE("SMS price"),
    FAVORITE_NUMBER("favorite number"),
    TARIFFICATION("tariffication"),
    START_PAY("start pay"),
    CALL_PRICE("call price"),
    TARIFF_PARAMETER("tariff parameter");

    private String value;

    TariffEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
