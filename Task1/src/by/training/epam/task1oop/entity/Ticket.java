package by.training.epam.task1oop.entity;

import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;

/**
         * abstract parent class "Ticket".
         * @since 03.05.2019
         */
    public abstract class Ticket {
     /**
      * * variable that stores information about location address.
      */
     private int ID;
     private String departurePoint;
     private String destinationPoint;
     private int numberOfDays;
     private Transport transport;
     private DateFormat dataStart;
     private DateFormat dataEnd;
     private int numberOfIngestion;
     private final Type type;

    @Override
    public boolean equals(Object o) {

        Ticket ticket = (Ticket) o;

        if (ID != ticket.ID) return false;
        if (numberOfDays != ticket.numberOfDays) return false;
        if (numberOfIngestion != ticket.numberOfIngestion) return false;
        if (departurePoint != null ? !departurePoint.equals(ticket.departurePoint) : ticket.departurePoint != null)
            return false;
        if (destinationPoint != null ? !destinationPoint.equals(ticket.destinationPoint) : ticket.destinationPoint != null)
            return false;
        if (transport != ticket.transport) return false;
        if (dataStart != null ? !dataStart.equals(ticket.dataStart) : ticket.dataStart != null) return false;
        if (dataEnd != null ? !dataEnd.equals(ticket.dataEnd) : ticket.dataEnd != null) return false;
        return type == ticket.type;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (departurePoint != null ? departurePoint.hashCode() : 0);
        result = 31 * result + (destinationPoint != null ? destinationPoint.hashCode() : 0);
        result = 31 * result + numberOfDays;
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        result = 31 * result + (dataStart != null ? dataStart.hashCode() : 0);
        result = 31 * result + (dataEnd != null ? dataEnd.hashCode() : 0);
        result = 31 * result + numberOfIngestion;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public String formStringToWrite(){
        String params = getType().toString() + "/";
        params += getDeparturePoint() + "/";
        params += getDestinationPoint() + "/";
        params += Integer.toString(getNumberOfDays()) + "/";
        params += getTransport() + "/";
        params += getDataStart() + "/";
        params += getDataEnd() + "/";
        params += Integer.toString(getNumberOfIngestion()) + "/";
        return params;
    }

    public void setNumberOfDays(int numberOfDays) {
                this.numberOfDays = numberOfDays;
            }

    public String getDeparturePoint() {
        return departurePoint;
    }
    public String getDestinationPoint() {
        return destinationPoint;
    }

    public int getID(){
        return ID;
    }
    public String getDataEnd() {
        return dataEnd.getDate();
    }
    public String getDataStart() {
        return dataStart.getDate();
    }
    public int getYearStart(){return dataStart.getYear();}
    public int getMonthStart(){return dataStart.getMonth();}
    public int getDayStart(){return dataStart.getDay();}
    public int getYearEnd(){return dataEnd.getYear();}
    public int getMonthEnd(){return dataEnd.getMonth();}
    public int getDayEnd(){return dataEnd.getDay();}
    public int getNumberOfDays() {
        return numberOfDays;
    }
    public Transport getTransport() {
        return transport;
    }
    public int getNumberOfIngestion() {
        return numberOfIngestion;
    }
    public Type getType() {
        return type;
    }

    public Ticket(int ID,String departure,String destination,int numberOfDays,Type t,Transport tr,DateFormat dS,DateFormat dE,int numOfIng){
        this.ID = ID;
        this.departurePoint = departure;
        this.destinationPoint = destination;
        this.type = t;
        this.transport = tr;
        this.dataStart = dS;
        this.dataEnd = dE;
        this.numberOfDays = numberOfDays;
        this.numberOfIngestion = numOfIng;

    }

    }
