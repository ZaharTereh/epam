package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.DateFormat;
import by.training.epam.task1oop.Transport;
import by.training.epam.task1oop.Type;

public class VacationTicket extends Ticket {
    private String nameOfHotel;
    public String getNameOfHotel() {
        return nameOfHotel;
    }

    @Override
    public String formStringToWrite(){
        String objectString = super.formStringToWrite();
        objectString += getNameOfHotel()+"/";
        return objectString;
    }

    public VacationTicket(String departure, String destination,int numerOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String nH){
        super(departure,destination,numerOfDays,type,tr,dS,dE,numOfIng);
        this.nameOfHotel = nH;
    }
}
