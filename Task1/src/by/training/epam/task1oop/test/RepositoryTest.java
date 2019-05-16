package by.training.epam.task1oop.test;

import by.training.epam.task1oop.entity.Ticket;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class RepositoryTest {
    @DataProvider(name = "correct")
    public Object[][] createCorrectData(){
        return
                new Object[][]{
                        {,},
                        {25,5},
                        {25,5},
                };
    }

    @Test(dataProvider = "correct",enabled = true)
    public void addObject(String[] object){
        ArrayList<Ticket> list = new ArrayList<>();

    }
}
