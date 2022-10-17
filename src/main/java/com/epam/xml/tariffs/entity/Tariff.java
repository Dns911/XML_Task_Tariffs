package com.epam.xml.tariffs.entity;


public class Tariff {
    private String name;
    private String operatorName;
    private double payroll;
    private CallPrice callPrice;
    private double smsPrice;
    private TariffParameter tariffParameter;

    public Tariff() {
    }

    public Tariff(String name, String operatorName, double payroll, CallPrice callPrice, double smsPrice, TariffParameter tariffParameter) {
        this.name = name;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.callPrice = callPrice;
        this.smsPrice = smsPrice;
        this.tariffParameter = tariffParameter;
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
        final StringBuilder sb = new StringBuilder("Tariff{");
        sb.append("name='").append(name).append('\'');
        sb.append(", operatorName='").append(operatorName).append('\'');
        sb.append(", payroll=").append(payroll);
        sb.append(", callPrice=").append(callPrice);
        sb.append(", smsPrice=").append(smsPrice);
        sb.append(", parameter=").append(tariffParameter);
        sb.append('}');
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
            final StringBuilder sb = new StringBuilder("CallPrice{");
            sb.append("innerCalls=").append(innerCalls);
            sb.append(", outerCalls=").append(outerCalls);
            sb.append(", fixedLineCalls=").append(fixedLineCalls);
            sb.append('}');
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
            final StringBuilder sb = new StringBuilder("TariffParameter{");
            sb.append("favoriteNum=").append(favoriteNum);
            sb.append(", tariffication=").append(tariffication);
            sb.append(", startPay=").append(startPay);
            sb.append('}');
            return sb.toString();
        }
    }

}
