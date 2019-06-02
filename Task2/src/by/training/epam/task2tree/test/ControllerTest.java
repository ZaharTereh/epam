package by.training.epam.task2tree.test;

import by.training.epam.task2tree.controller.Controller;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ControllerTest {
    private Controller controller;

    @Test(description = "test for add",enabled = true)
    public void getInstanceCorrect(){
        controller = Controller.getInstance();
        Assert.assertNotNull(controller,"Instance is not NULL");
    }
}
