package by.training.epam.task2tree.test;

import by.training.epam.task2tree.controller.Controller;
import by.training.epam.task2tree.controller.Creator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatorTest {
    @DataProvider(name = "correct")
    public Object[][] createCorrectDataCreateController(){
        return
                new Object[][]{
                        {true},
                };
    }
    @Test(description = "test for create controller",dataProvider = "correct",enabled = true)
    public void createControllerCorrect(boolean expected){

        Controller controller = Creator.createController();
        boolean result = "class by.training.epam.task2tree.controller.Controller".equals(controller.getClass().toString());

        Assert.assertEquals(result,expected,"compare is correct");
    }
}
