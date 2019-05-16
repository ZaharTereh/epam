package by.training.epam.task1oop.factory;

import by.training.epam.task1oop.enm.Type;
import by.training.epam.task1oop.entity.Ticket;

public  interface  TicketFactory {

     Ticket createTicket(String[] object,int ID);

      static TicketFactory createConcretFactory(Type type) throws RuntimeException{
          switch (type) {
               case VACATION:
                    return new VacationTicketFactory();
               case CRUISE:
                    return new CruiseTicketFactory();
               case SHOPPING:
                    return new ShoppingTicketFactory();
               case EXCURSION:
                    return new ExcursionTicketFactory();
               case TREATMENT:
                    return new TreatmentTicketFactory();

               default:throw new RuntimeException();
          }
     }
}
