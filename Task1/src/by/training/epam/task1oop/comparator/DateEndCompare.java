package by.training.epam.task1oop.comparator;

import by.training.epam.task1oop.DateFormat;
import by.training.epam.task1oop.entity.Ticket;

import java.util.Comparator;

public class DateEndCompare implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        DateFormat obj1;
        DateFormat obj2;
        obj1 = DateFormat.parseDate(o1.getDataEnd());
        obj2 = DateFormat.parseDate(o2.getDataEnd());
        return obj1.compareTo(obj2);
    }
}
