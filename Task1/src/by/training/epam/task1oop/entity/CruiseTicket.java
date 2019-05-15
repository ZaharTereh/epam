package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;

public class CruiseTicket extends Ticket {

    private String nameOfSea;
    public String getNameOfSea() {
        return nameOfSea;
    }

    @Override
    public String formStringToWrite() {
        String objectString = super.formStringToWrite();
        objectString += getNameOfSea() + "/";
        return objectString;
    }

    public CruiseTicket(String departure, String destination,int numberOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String nameOfSea) {
        super(departure, destination,numberOfDays,type, tr, dS, dE, numOfIng);
        this.nameOfSea = nameOfSea;
    }
}
