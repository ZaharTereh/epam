package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;

public class ExcursionTicket extends Ticket {
    private String place;
    public String getPlace() {
        return place;
    }

    @Override
    public String formStringToWrite(){
        String objectString = super.formStringToWrite();
        objectString += getPlace()+"/";
        return objectString;
    }

    public ExcursionTicket(int ID,String departure, String destination,int numberOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String place){
        super(ID,departure,destination,numberOfDays,type,tr,dS,dE,numOfIng);
        this.place = place;
    }
}
