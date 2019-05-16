package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        VacationTicket that = (VacationTicket) o;

        return nameOfHotel != null ? nameOfHotel.equals(that.nameOfHotel) : that.nameOfHotel == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nameOfHotel != null ? nameOfHotel.hashCode() : 0);
        return result;
    }

    public VacationTicket(int ID, String departure, String destination, int numberOfDays, Type type, Transport tr, DateFormat dS, DateFormat dE, int numOfIng, String nH){
        super(ID,departure,destination,numberOfDays,type,tr,dS,dE,numOfIng);
        this.nameOfHotel = nH;
    }
}
