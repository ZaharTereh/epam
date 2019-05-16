package by.training.epam.task1oop.specification;

import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.entity.Ticket;

public class SearchByEndDate implements Specification {
    DateFormat dateEnd;
    @Override
    public boolean search(Ticket ticket) {
        DateFormat date = DateFormat.parseDate(ticket.getDataEnd());
        if(dateEnd.compareTo(date) == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public SearchByEndDate(int year,int month,int day){
        dateEnd = new DateFormat(year,month,day);
    }
}
