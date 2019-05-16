package by.training.epam.task1oop.specification;

import by.training.epam.task1oop.entity.Ticket;

public class SearchByDeparturePoint implements Specification {
    String derapturePoint;
    @Override
    public boolean search(Ticket ticket) {
        if(derapturePoint.equals(ticket.getDeparturePoint())){
            return true;
        }
        else {
            return false;
        }
    }
    public SearchByDeparturePoint(String derapturePoint){
        this.derapturePoint = derapturePoint;
    }
}
