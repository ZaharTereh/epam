package by.training.epam.task1oop;

import by.training.epam.task1oop.comparator.SortByDateStart;
import by.training.epam.task1oop.entity.*;
import by.training.epam.task1oop.repository.Creator;
import by.training.epam.task1oop.repository.Repository;
import by.training.epam.task1oop.specification.SearchByType;

/**
 * Programm-Task1 OOP.
 @since 03.05.2019
 */
public final class Run {
    /**
     * *
     @since 03.05.2019
     */
    private Run() { }
    /**
     * @param args array
     *
     *@since03.05.2019
     */
    public static void main(final String[] args) {

        Repository repository = null;
        try {
            repository = Creator.createRepository();
        }catch (Exception ex){
            ex.getMessage();
        }
         repository.readObjectsFromFile();

      for (Ticket ticket:repository.listObjects){
          System.out.println(ticket.getDataStart());
      }

      System.out.println("After");
        repository.sortObject(new SortByDateStart());

       // Repository.repository.deleteObject();

        for (Ticket ticket:repository.listObjects){
            System.out.println(ticket.getDataStart());
        }

        repository.searchObject(new SearchByType(by.training.epam.task1oop.enm.Type.CRUISE));
        for (Ticket temp:repository.listForSearch) {
            System.out.println(temp.formStringToWrite());
        }
      }
    }
