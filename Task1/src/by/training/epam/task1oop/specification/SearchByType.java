package by.training.epam.task1oop.specification;

import by.training.epam.task1oop.enm.Type;
import by.training.epam.task1oop.entity.Ticket;

public class SearchByType implements Specification {
    Type type;

    @Override
    public boolean search(Ticket ticket) {
        if(type == ticket.getType()){
            return true;
        }
        else {
            return false;
        }
    }

    public SearchByType(Type type) {
        this.type = type;
    }
}