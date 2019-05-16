package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;

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

    public ShoppingTicket(int ID,String departure, String destination,int numberOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String nSpM, int nShops){
        super(ID,departure,destination,numberOfDays,type,tr,dS,dE,numOfIng);
        this.nameOfSupermarket = nSpM;
        this.numberOfShops = nShops;
    }
}
