package by.training.epam.task1oop;

import by.training.epam.task1oop.entity.*;
import by.training.epam.task1oop.factory.*;

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
      Repository repository = new Repository();

      repository.readObjectsFromFile();




      for (Ticket ticket:repository.listObjects){
          System.out.println(ticket.getDataStart());
      }

      System.out.println("After");
      repository.sortByDateStart();

        for (Ticket ticket:repository.listObjects){
            System.out.println(ticket.getDataStart());
        }
      }
    }
