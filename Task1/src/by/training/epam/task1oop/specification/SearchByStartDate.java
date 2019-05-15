package by.training.epam.task1oop.specification;

import by.training.epam.task1oop.DateFormat;
import by.training.epam.task1oop.entity.Ticket;

public class SearchByStartDate implements Specification {
    DateFormat dateStart;
    @Override
    public boolean search(Ticket ticket) {
        DateFormat date = DateFormat.parseDate(ticket.getDataStart());
        if(dateStart.compareTo(date) == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public SearchByStartDate(int year,int mounth,int day){
        dateStart = new DateFormat(year,mounth,day);
    }
}
