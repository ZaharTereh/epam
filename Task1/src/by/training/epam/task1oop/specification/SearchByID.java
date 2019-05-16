package by.training.epam.task1oop.specification;

import by.training.epam.task1oop.entity.Ticket;

public class SearchByID implements Specification {
    private int ID;
    @Override
    public boolean search(Ticket ticket) {
        if(ID == ticket.getID()){
            return true;
        }
        else {
            return false;
        }
    }

    public SearchByID(int ID){
        this.ID = ID;
    }
}
