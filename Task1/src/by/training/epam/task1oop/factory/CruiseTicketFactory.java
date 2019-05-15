package by.training.epam.task1oop.factory;

import by.training.epam.task1oop.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;
import by.training.epam.task1oop.entity.CruiseTicket;

public class CruiseTicketFactory implements TicketFactory {
    @Override
    public CruiseTicket createTicket(String[] object) {
        Type type = Type.valueOf(object[0]);
        String departurePoint = object[1];
        String destinationPoint = object[2];
        int numberOfDays = Integer.parseInt(object[3]);
        Transport transport = Transport.valueOf(object[4]);
        DateFormat dataStart = DateFormat.parseDate(object[5]);
        DateFormat dataEnd = DateFormat.parseDate(object[6]);
        int numberOfIngestion = Integer.parseInt(object[7]);
        String nameOfSea = object[8];
        return new CruiseTicket(departurePoint,destinationPoint,numberOfDays,type,transport,dataStart,dataEnd,numberOfIngestion,nameOfSea);
    }
}
