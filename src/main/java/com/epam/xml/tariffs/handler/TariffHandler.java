package com.epam.xml.tariffs.handler;

import com.epam.xml.tariffs.entity.Tariff;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TariffHandler extends DefaultHandler {
    private Set<Tariff> tariffs;
    private Tariff current;
    private TariffEnum currentEnum;
    private EnumSet<TariffEnum> withText;
    private static final String ELEMENT_TARIFF = "tariff";
    public TariffHandler() {
        tariffs = new HashSet<>();
        withText = EnumSet.range(TariffEnum.PAYROLL, TariffEnum.START_PAY);
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_TARIFF.equals(qName)) {
            current = new Tariff();
            current.setName(attrs.getValue(0));
            current.setOperatorName(attrs.getValue(1));
        } else {
            TariffEnum temp = TariffEnum.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_TARIFF.equals(qName)) {
            tariffs.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentEnum!= null) {
            switch (currentEnum) {
                case PAYROLL -> current.setPayroll(Double.parseDouble(data));
                case INNER_CALLS -> current.getCallPrice().setInnerCalls(Double.parseDouble(data));
                case OUTER_CALLS -> current.getCallPrice().setOuterCalls(Double.parseDouble(data));
                case FIXED_LINE_CALLS -> current.getCallPrice().setFixedLineCalls(Double.parseDouble(data));
                case SMS_PRICE -> current.setSmsPrice(Double.parseDouble(data));
                case FAVORITE_NUMBER -> current.getTariffParameter().setFavoriteNum(Integer.parseInt(data));
                case TARIFFICATION -> current.getTariffParameter().setTariffication(Integer.parseInt(data));
                case START_PAY -> current.getTariffParameter().setStartPay(Double.parseDouble(data));
                default -> throw new EnumConstantNotPresentException(
                        currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

}
