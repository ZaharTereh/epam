package by.training.epam.task1oop.factory;

import by.training.epam.task1oop.DateFormat;
import by.training.epam.task1oop.Transport;
import by.training.epam.task1oop.Type;
import by.training.epam.task1oop.entity.VacationTicket;


public class VacationTicketFactory implements TicketFactory {

    @Override
    public VacationTicket createTicket(String[] object) {
        Type type = Type.valueOf(object[0]);
        String departurePoint = object[1];
        String destinationPoint = object[2];
        int numberOfDays = Integer.parseInt(object[3]);
        Transport transport = Transport.valueOf(object[4]);
        DateFormat dataStart = DateFormat.parseDate(object[5]);
        DateFormat dataEnd = DateFormat.parseDate(object[6]);
        int numberOfIngestion = Integer.parseInt(object[7]);
        String nameOfHotel = object[8];
      return new VacationTicket(departurePoint,destinationPoint,numberOfDays,type,transport,dataStart,dataEnd,numberOfIngestion,nameOfHotel);
    }
}
