package by.training.epam.task1oop;

import by.training.epam.task1oop.comparator.DateStartCompare;
import by.training.epam.task1oop.entity.*;
import by.training.epam.task1oop.repository.Repository;

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

      Repository.getRepository();
      Repository.repository.readObjectsFromFile();


      for (Ticket ticket:Repository.repository.listObjects){
          System.out.println(ticket.getDataStart());
      }

      System.out.println("After");
        Repository.repository.sortObject(new DateStartCompare());

       // Repository.repository.deleteObject();

        for (Ticket ticket:Repository.repository.listObjects){
            System.out.println(ticket.getDataStart());
        }


      }
    }
