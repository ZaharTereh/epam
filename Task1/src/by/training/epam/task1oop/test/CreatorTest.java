package by.training.epam.task1oop.test;

import by.training.epam.task1oop.repository.Creator;
import by.training.epam.task1oop.repository.Repository;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatorTest {

    @Test(enabled = true)
    public void createRepository(){
        Repository repository;
        repository = Creator.createRepository();
        boolean temp;
        if(repository != null){
            temp = true;
        }
        else {
            temp = false;
        }

        Assert.assertEquals(temp,true,"creation is correct");
    }
}
