package by.training.epam.task1oop.comparator;

import by.training.epam.task1oop.entity.Ticket;

import java.util.Comparator;

public class NumberOfDaysCompare implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getNumberOfDays() < o2.getNumberOfDays()) {
            return -1;
        } else if (o1.getNumberOfDays() == o2.getNumberOfDays()) {
            return 0;
        } else {
            return 1;
        }
    }
}
