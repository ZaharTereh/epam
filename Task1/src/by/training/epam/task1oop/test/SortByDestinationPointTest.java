package by.training.epam.task1oop.test;

import by.training.epam.task1oop.comparator.SortByDateEnd;
import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;
import by.training.epam.task1oop.entity.Ticket;
import by.training.epam.task1oop.entity.VacationTicket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortByDestinationPointTest {
    @DataProvider(name = "correct")
    public Object[][] createCorrectData(){
        return
                new Object[][]{
                        {new VacationTicket(0, "", "Ankara", 1,
                                Type.VACATION, Transport.PLANE, new DateFormat(2019, 3, 3),
                                new DateFormat(2019, 3, 4), 2, ""),
                                new VacationTicket(0, "", "Minsk", 1,
                                        Type.VACATION, Transport.PLANE, new DateFormat(2019, 3, 3),
                                        new DateFormat(2019, 4, 4), 2, ""),
                                -1
                        },
                        {new VacationTicket(0, "", "Minsk", 1,
                                Type.VACATION, Transport.PLANE, new DateFormat(2019, 3, 3),
                                new DateFormat(2019, 7, 7), 2, ""),
                                new VacationTicket(0, "", "Ankara", 1,
                                        Type.VACATION, Transport.PLANE, new DateFormat(2019, 3, 3),
                                        new DateFormat(2019, 6, 6), 2, ""),
                                1
                        },
                        {new VacationTicket(0, "", "Minsk", 1,
                                Type.VACATION, Transport.PLANE, new DateFormat(2019, 3, 3),
                                new DateFormat(2019, 5, 5), 2, ""),
                                new VacationTicket(0, "", "Minsk", 1,
                                        Type.VACATION, Transport.PLANE, new DateFormat(2019, 3, 3),
                                        new DateFormat(2019, 5, 5), 2, ""),
                                0
                        }
                };
    }
    @Test(dataProvider = "correct",enabled = true)
    public void compare(Ticket o1, Ticket o2, int rezult){
        Assert.assertEquals(new SortByDateEnd().compare(o1,o2),rezult,"creation is correct");
    }
}
