package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.DateFormat;
import by.training.epam.task1oop.Transport;
import by.training.epam.task1oop.Type;

import java.util.Date;

public class ShoppingTicket extends Ticket {

    private String nameOfSupermarket;
    private int numberOfShops;

    public String getNameOfSupermarket() {
        return nameOfSupermarket;
    }
    public int getNumberOfShops() {
        return numberOfShops;
    }

    @Override
    public String formStringToWrite(){
        String objectString = super.formStringToWrite();
        objectString += getNameOfSupermarket()+"/";
        objectString += getNumberOfShops()+"/";
        return objectString;
    }

    public ShoppingTicket(String departure, String destination,int numerOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String nSpM, int nShops){
        super(departure,destination,numerOfDays,type,tr,dS,dE,numOfIng);
        this.nameOfSupermarket = nSpM;
        this.numberOfShops = nShops;
    }
}
