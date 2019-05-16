package by.training.epam.task1oop.specification;

import by.training.epam.task1oop.entity.Ticket;

public class SearchByDestinationPoint implements  Specification {
    String derstinatioPoint;
    @Override
    public boolean search(Ticket ticket) {
        if(derstinatioPoint.equals(ticket.getDestinationPoint())){
            return true;
        }
        else {
            return false;
        }
    }
    public SearchByDestinationPoint(String derstinatioPoint){
        this.derstinatioPoint = derstinatioPoint;
    }
}
