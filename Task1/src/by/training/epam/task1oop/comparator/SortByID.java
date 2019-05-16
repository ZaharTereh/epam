package by.training.epam.task1oop.comparator;

import by.training.epam.task1oop.entity.Ticket;

import java.util.Comparator;

public class SortByID implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if(o1.getID() < o2.getID()){
            return -1;
        }else if(o1.getID() > o2.getID()){
            return 1;
        }else {
            return 0;
        }
    }
}
