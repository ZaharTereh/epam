package by.training.epam.task1oop.factory;

import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;
import by.training.epam.task1oop.entity.ShoppingTicket;

public class ShoppingTicketFactory implements TicketFactory {
    @Override
    public ShoppingTicket createTicket(String[] object,int ID) {
        Type type = Type.valueOf(object[0]);
        String departurePoint = object[1];
        String destinationPoint = object[2];
        int numberOfDays = Integer.parseInt(object[3]);
        Transport transport = Transport.valueOf(object[4]);
        DateFormat dataStart = DateFormat.parseDate(object[5]);
        DateFormat dataEnd = DateFormat.parseDate(object[6]);
        int numberOfIngestion = Integer.parseInt(object[7]);
        String nameOfSupermarket = object[8];
        int numberOfShops = Integer.parseInt(object[9]);
        return new ShoppingTicket(ID,departurePoint,destinationPoint,numberOfDays,type,transport,dataStart,dataEnd,numberOfIngestion,nameOfSupermarket,numberOfShops);
    }
}
