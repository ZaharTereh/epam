package by.training.epam.task4xml.bean;

public class TariffWithoutCalls {
    private String name;
    private Operator operator;
    private int megabytes;
    private double priceForOneMB;
    private double payroll;
    private String date;
    private double priceForConnect;

    public double getPriceForConnect() {
        return priceForConnect;
    }

    public void setPriceForConnect(double priceForConnect) {
        this.priceForConnect = priceForConnect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int getMegabytes() {
        return megabytes;
    }

    public void setMegabytes(int megabytes) {
        this.megabytes = megabytes;
    }

    public double getPriceForOneMB() {
        return priceForOneMB;
    }

    public void setPriceForOneMB(double priceForOneMB) {
        this.priceForOneMB = priceForOneMB;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
