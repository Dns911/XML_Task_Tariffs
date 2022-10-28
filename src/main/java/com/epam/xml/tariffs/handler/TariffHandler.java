package com.epam.xml.tariffs.handler;

import com.epam.xml.tariffs.entity.Tariff;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.Instant;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TariffHandler extends DefaultHandler {
    private Set<Tariff> tariffs;
    private Tariff current;
    private TariffTag currentTag;
    private EnumSet<TariffTag> withText;
    private static final String ELEMENT_TARIFF = "tariff";

    public TariffHandler() {
        tariffs = new HashSet<>();
        withText = EnumSet.range(TariffTag.START_DATE, TariffTag.START_PAY);
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_TARIFF.equals(qName)) {
            current = new Tariff();
            if (attrs.getLocalName(0).equals("name")) {
                current.setName(attrs.getValue(0));
                current.setOperatorName(attrs.getValue(1));

            } else if (attrs.getLocalName(1).equals("name")) {
                current.setName(attrs.getValue(1));
                current.setOperatorName(attrs.getValue(0));
            }

        } else {
            TariffTag temp = TariffTag.getTag(qName);
            if (withText.contains(temp)) {
                currentTag = temp;
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
        if (currentTag != null) {
            switch (currentTag.getValue()) {
                case "startDate" -> current.setStartDate(Instant.parse(data + "T00:00:00.00Z"));
                case "payroll" -> current.setPayroll(Double.parseDouble(data));
                case "innerCalls" -> current.getCallPrice().setInnerCalls(Double.parseDouble(data));
                case "outerCalls" -> current.getCallPrice().setOuterCalls(Double.parseDouble(data));
                case "fixedLineCalls" -> current.getCallPrice().setFixedLineCalls(Double.parseDouble(data));
                case "smsPrice" -> current.setSmsPrice(Double.parseDouble(data));
                case "favoriteNum" -> current.getTariffParameter().setFavoriteNum(Integer.parseInt(data));
                case "tariffication" -> current.getTariffParameter().setTariffication(Integer.parseInt(data));
                case "startPay" -> current.getTariffParameter().setStartPay(Double.parseDouble(data));
                default -> throw new EnumConstantNotPresentException(
                        currentTag.getDeclaringClass(), currentTag.name());
            }
        }
        currentTag = null;
    }

}
