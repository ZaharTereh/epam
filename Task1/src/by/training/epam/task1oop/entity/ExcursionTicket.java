package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.DateFormat;
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

    public ExcursionTicket(String departure, String destination,int numerOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String place){
        super(departure,destination,numerOfDays,type,tr,dS,dE,numOfIng);
        this.place = place;
    }
}
