package by.training.epam.task1oop.factory;

import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;
import by.training.epam.task1oop.entity.ExcursionTicket;

public class ExcursionTicketFactory implements TicketFactory {
    @Override
    public ExcursionTicket createTicket(String[] object,int ID){
    Type type = Type.valueOf(object[0]);
    String departurePoint = object[1];
    String destinationPoint = object[2];
    int numberOfDays = Integer.parseInt(object[3]);
    Transport transport = Transport.valueOf(object[4]);
    DateFormat dataStart =DateFormat.parseDate(object[5]);
    DateFormat dataEnd = DateFormat.parseDate(object[6]);
    int numberOfIngestion = Integer.parseInt(object[7]);
    String place = object[8];
        return new ExcursionTicket(ID,departurePoint,destinationPoint,numberOfDays,type,transport,dataStart,dataEnd,numberOfIngestion,place);
    }
}
