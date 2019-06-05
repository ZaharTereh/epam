package by.training.epam.task2tree.test;

import by.training.epam.task2tree.repository.Repository;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepositoryTest {
    private Repository repository;

    @Test(description = "test for add",enabled = true)
    public void getInstanceCorrect(){
        repository = Repository.getInstance();
        Assert.assertNotNull(repository,"Instance is not NULL");
    }
}
