package by.training.epam.task1oop.comparator;

import by.training.epam.task1oop.entity.Ticket;

import java.util.Comparator;

public class SortByDeparturePoint implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
       return o1.getDeparturePoint().compareTo(o2.getDeparturePoint());
    }
}
