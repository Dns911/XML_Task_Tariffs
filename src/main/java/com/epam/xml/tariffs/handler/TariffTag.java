package com.epam.xml.tariffs.handler;

public enum TariffTag {
    TARIFFS("tariffs"),
    UNIQUE_NAME ("unique_Name"),
    NAME("name"),
    OPERATOR_NAME("operator_Name"),
    TARIFF("tariff"),
    START_DATE("start_Date"),
    PAYROLL("payroll"),
    INNER_CALLS("inner_Calls"),
    OUTER_CALLS("outer_Calls"),
    FIXED_LINE_CALLS("fixed_Line_Calls"),
    SMS_PRICE("sms_Price"),
    FAVORITE_NUM("favorite_Num"),
    TARIFFICATION("tariffication"),
    START_PAY("start_Pay"),
    CALL_PRICE("Call_Price"),
    TARIFF_PARAMETER("Tariff_Parameter");

    private String value;

    TariffTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
