package by.training.epam.task4xml.bean;

import java.util.ArrayList;

public class TariffWithCalls extends TariffWithoutCalls{
    private double priceInside;
    private double priceOutside;
    private double priceLendline;
    private int freeMinutes;
    private double priceForSms;
    private short maxLengthSms;
    private String tariffication;
    private long number;
    private ArrayList<String> likeNumbers = new ArrayList<>();

    public String getLikeNumber(int index){
        return likeNumbers.get(index);
    }

    public void setLikeNumber(String number){
        if(likeNumbers.size()<5) {
            likeNumbers.add(number);
        }
    }

    public int getSizeLikeNumbers(){
        return likeNumbers.size();
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public double getPriceInside() {
        return priceInside;
    }

    public void setPriceInside(double priceInside) {
        this.priceInside = priceInside;
    }

    public double getPriceOutside() {
        return priceOutside;
    }

    public void setPriceOutside(double priceOutside) {
        this.priceOutside = priceOutside;
    }

    public double getPriceLendline() {
        return priceLendline;
    }

    public void setPriceLendline(double priceLendline) {
        this.priceLendline = priceLendline;
    }

    public int getFreeMinutes() {
        return freeMinutes;
    }

    public void setFreeMinutes(int freeMinutes) {
        this.freeMinutes = freeMinutes;
    }

    public double getPriceForSms() {
        return priceForSms;
    }

    public void setPriceForSms(double priceForSms) {
        this.priceForSms = priceForSms;
    }

    public short getMaxLengthSms() {
        return maxLengthSms;
    }

    public void setMaxLengthSms(short maxLengthSms) {
        this.maxLengthSms = maxLengthSms;
    }

    public String getTariffication() {
        return tariffication;
    }

    public void setTariffication(String tariffication) {
        this.tariffication = tariffication;
    }
}
