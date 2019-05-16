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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ExcursionTicket that = (ExcursionTicket) o;

        return place != null ? place.equals(that.place) : that.place == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (place != null ? place.hashCode() : 0);
        return result;
    }

    public ExcursionTicket(int ID, String departure, String destination, int numberOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String place){
        super(ID,departure,destination,numberOfDays,type,tr,dS,dE,numOfIng);
        this.place = place;
    }
}
