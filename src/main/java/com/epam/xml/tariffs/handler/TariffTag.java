package com.epam.xml.tariffs.handler;

import java.util.Arrays;
import java.util.List;

public enum TariffTag {
    TARIFFS("tariffs"),
    UNIQUE_NAME ("uniqueName"),
    NAME("name"),
    OPERATOR_NAME("operatorName"),
    TARIFF("tariff"),
    START_DATE("startDate"),
    PAYROLL("payroll"),
    INNER_CALLS("innerCalls"),
    OUTER_CALLS("outerCalls"),
    FIXED_LINE_CALLS("fixedLineCalls"),
    SMS_PRICE("smsPrice"),
    FAVORITE_NUM("favoriteNum"),
    TARIFFICATION("tariffication"),
    START_PAY("startPay"),
    CALL_PRICE("CallPrice"),
    TARIFF_PARAMETER("TariffParameter");

    private String value;

    TariffTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    static public TariffTag getTag(String value){
        List<TariffTag> result = Arrays.stream(TariffTag.values()).filter(e -> e.getValue().equals(value)).toList();
        return result.get(0);
    }
}
