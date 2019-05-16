package by.training.epam.task1oop.specification;

import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.entity.Ticket;


public class SearchBetweenDates implements Specification {
    DateFormat dateStart;
    DateFormat dateEnd;

    @Override
    public boolean search(Ticket ticket) {
        DateFormat start = DateFormat.parseDate(ticket.getDataStart());
        DateFormat end = DateFormat.parseDate(ticket.getDataEnd());

        if((dateStart.compareTo(start) == 0 || dateStart.compareTo(start) == -1)&&(dateEnd.compareTo(end) ==0 || dateEnd.compareTo(end)==1)){
            return true;
        }
        else {
            return false;
        }
    }

    public SearchBetweenDates(int year_s,int month_s,int day_s,int year_e,int month_e,int day_e){
        dateStart = new DateFormat(year_s,month_s,day_s);
        dateEnd = new DateFormat(year_e,month_e,day_e);
    }
}
