package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.date.DateFormat;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TreatmentTicket that = (TreatmentTicket) o;

        return nameOfSanatorium != null ? nameOfSanatorium.equals(that.nameOfSanatorium) : that.nameOfSanatorium == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nameOfSanatorium != null ? nameOfSanatorium.hashCode() : 0);
        return result;
    }

    public TreatmentTicket(int ID, String departure, String destination, int numberOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String nS){
        super(ID,departure,destination,numberOfDays,type,tr,dS,dE,numOfIng);
        this.nameOfSanatorium = nS;
    }
}
