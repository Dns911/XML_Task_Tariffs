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
    private TariffTags currentTags;
    private EnumSet<TariffTags> withText;
    private static final String ELEMENT_TARIFF = "tariff";

    public TariffHandler() {
        tariffs = new HashSet<>();
        withText = EnumSet.range(TariffTags.PAYROLL, TariffTags.STARTPAY);
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_TARIFF.equals(qName)) {
            current = new Tariff();
            if (attrs.getLocalName(0) == "name") {
                current.setName(attrs.getValue(0));
                current.setOperatorName(attrs.getValue(1));
            } else {
                current.setName(attrs.getValue(1));
                current.setOperatorName(attrs.getValue(0));
            }
        } else {
            TariffTags temp = TariffTags.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentTags = temp;
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
        if (currentTags != null) {
            switch (currentTags) {
                case PAYROLL -> current.setPayroll(Double.parseDouble(data));
                case INNERCALLS -> current.getCallPrice().setInnerCalls(Double.parseDouble(data));
                case OUTERCALLS -> current.getCallPrice().setOuterCalls(Double.parseDouble(data));
                case FIXEDLINECALLS -> current.getCallPrice().setFixedLineCalls(Double.parseDouble(data));
                case SMSPRICE -> current.setSmsPrice(Double.parseDouble(data));
                case FAVORITENUM -> current.getTariffParameter().setFavoriteNum(Integer.parseInt(data));
                case TARIFFICATION -> current.getTariffParameter().setTariffication(Integer.parseInt(data));
                case STARTPAY -> current.getTariffParameter().setStartPay(Double.parseDouble(data));
                default -> throw new EnumConstantNotPresentException(
                        currentTags.getDeclaringClass(), currentTags.name());
            }
        }
        currentTags = null;
    }

}
