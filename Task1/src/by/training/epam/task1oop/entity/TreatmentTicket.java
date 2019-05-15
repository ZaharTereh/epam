package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;

public class TreatmentTicket extends Ticket {

    private String nameOfSanatorium;
    public String getNameOfSanatorium() {
        return nameOfSanatorium;
    }

    @Override
    public String formStringToWrite(){
        String objectString = super.formStringToWrite();
        objectString += getNameOfSanatorium()+"/";
        return objectString;
    }

    public TreatmentTicket(String departure, String destination,int numerOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String nS){
        super(departure,destination,numerOfDays,type,tr,dS,dE,numOfIng);
        this.nameOfSanatorium = nS;
    }
}
