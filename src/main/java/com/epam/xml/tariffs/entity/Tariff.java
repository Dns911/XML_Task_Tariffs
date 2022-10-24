package com.epam.xml.tariffs.entity;

import java.time.Instant;

public class Tariff {
    private String uniqueName;
    private String name;
    private String operatorName;
    private Instant startDate;
    private double payroll;
    private CallPrice callPrice = new CallPrice();
    private double smsPrice;
    private TariffParameter tariffParameter = new TariffParameter();

    public Tariff() {
    }

    public Tariff(String name, String operatorName, Instant startDate, double payroll, CallPrice callPrice, double smsPrice, TariffParameter tariffParameter) {
        this.name = name;
        this.operatorName = operatorName;
        this.startDate = startDate;
        this.payroll = payroll;
        this.callPrice = callPrice;
        this.smsPrice = smsPrice;
        this.tariffParameter = tariffParameter;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    public CallPrice getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(CallPrice callPrice) {
        this.callPrice = callPrice;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    public TariffParameter getTariffParameter() {
        return tariffParameter;
    }

    public void setTariffParameter(TariffParameter tariffParameter) {
        this.tariffParameter = tariffParameter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nTARIFF ");
        sb.append("\sid: ").append(uniqueName);
        sb.append("\nName: ").append(name);
        sb.append("\nOperator: ").append(operatorName);
        sb.append("\nDate start: ").append(startDate);
        sb.append("\nPayroll: ").append(payroll).append(" BYN");
        sb.append(callPrice);
        sb.append("\nSMS Price: ").append(smsPrice).append(" BYN/sms");
        sb.append(tariffParameter).append("\n");
        return sb.toString();
    }

    public class CallPrice {
        private double innerCalls;
        private double outerCalls;
        private double fixedLineCalls;

        public CallPrice() {
        }

        public CallPrice(double innerCalls, double outerCalls, double fixedLineCalls) {
            this.innerCalls = innerCalls;
            this.outerCalls = outerCalls;
            this.fixedLineCalls = fixedLineCalls;
        }

        public double getInnerCalls() {
            return innerCalls;
        }

        public void setInnerCalls(double innerCalls) {
            this.innerCalls = innerCalls;
        }

        public double getOuterCalls() {
            return outerCalls;
        }

        public void setOuterCalls(double outerCalls) {
            this.outerCalls = outerCalls;
        }

        public double getFixedLineCalls() {
            return fixedLineCalls;
        }

        public void setFixedLineCalls(double fixedLineCalls) {
            this.fixedLineCalls = fixedLineCalls;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\nCall Prices:");
            sb.append("\n\tInner Calls: ").append(innerCalls).append(" BYN/min");
            sb.append("\n\tOuter Calls: ").append(outerCalls).append(" BYN/min");
            sb.append("\n\tFixed Line Calls: ").append(fixedLineCalls).append(" BYN/min");
            return sb.toString();
        }
    }

    public class TariffParameter {
        private int favoriteNum;
        private int tariffication;
        private double startPay;

        public TariffParameter() {
        }

        public TariffParameter(int favoriteNum, int tariffication, double startPay) {
            this.favoriteNum = favoriteNum;
            this.tariffication = tariffication;
            this.startPay = startPay;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public int getTariffication() {
            return tariffication;
        }

        public void setTariffication(int tariffication) {
            this.tariffication = tariffication;
        }

        public double getStartPay() {
            return startPay;
        }

        public void setStartPay(double startPay) {
            this.startPay = startPay;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\nOther: ");
            sb.append("\n\tFavorite numbers: ").append(favoriteNum);
            sb.append("\n\tTariffication: ").append(tariffication).append(" sec");
            sb.append("\n\tStart Pay: ").append(startPay).append(" BYN");
            return sb.toString();
        }
    }

}
