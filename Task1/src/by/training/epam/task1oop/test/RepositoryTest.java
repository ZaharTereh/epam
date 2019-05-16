package by.training.epam.task1oop.test;

import by.training.epam.task1oop.comparator.SortByDateStart;
import by.training.epam.task1oop.enm.Type;
import by.training.epam.task1oop.entity.Ticket;
import by.training.epam.task1oop.repository.Creator;
import by.training.epam.task1oop.repository.Repository;
import by.training.epam.task1oop.specification.SearchByType;
import by.training.epam.task1oop.specification.Specification;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;


public class RepositoryTest {

    @DataProvider(name = "incorrectAdd")
    public Object[][] createNegativeDataAdd(){
        return
                new String[][]{
                        {"VACATION","Minsk","Moskow","4","MINIBUS","2019 1 32","2019 2 30","3","Olimp"},
                        {"CRUISE","Minsk","Moskow","11","PLAIN","2020 4 20","2020 5 1","3","Olimp"}
                };
    }
    @Test(dataProvider = "incorrectAdd",enabled = true)
    public void addObjectNegative(String[] object){
        Repository repository;
        repository = Creator.createRepository();

        repository.listObjects.clear();

        repository.addObject(object);
        boolean temp = repository.listObjects.isEmpty();

        Assert.assertEquals(temp,true,"creation is correct");
    }

    @DataProvider(name = "correctAdd")
    public Object[][] createCorrectDataAdd(){
        return
                new String[][]{
                        {"VACATION","Minsk","Moskow","4","MINIBUS","2019 1 3","2019 5 5","3","Olimp"},
                        {"CRUISE","Minsk","Moskow","11","SHIP","2020 4 20","2020 5 1","3","Olimp"}
                };
    }
    @Test(dataProvider = "correctAdd",enabled = true)
    public void addObjectCorrect(String[] object){
        Repository repository;
        repository = Creator.createRepository();
        repository.listObjects.clear();
        repository.addObject(object);
        boolean temp = repository.listObjects.isEmpty();

        Assert.assertEquals(temp,false,"creation is correct");
    }


    @DataProvider(name = "correctDelete")
    public Object[][] createCorrectDataDelete(){
        return
                new Integer[][]{
                        {0}
                };
    }
    @Test(dataProvider = "correctDelete",enabled = true)
    public void deleteObjectCorrect(int ID){
        Repository repository;

        repository = Creator.createRepository();
        String[] params = {"VACATION","Minsk","Moskow","4","MINIBUS","2019 1 3","2019 5 5","3","Olimp"};
        repository.listObjects.clear();
        repository.addObject(params);
        repository.deleteObject(ID);

        boolean temp = repository.listObjects.isEmpty();

        Assert.assertEquals(temp,true,"creation is correct");
    }


    @DataProvider(name = "incorrectDelete")
    public Object[][] createNegativeDataDelete(){
        return
                new Integer[][]{
                        {-1},
                        {1}
                };
    }
    @Test(dataProvider = "incorrectDelete",enabled = true)
    public void deleteObjectNegative(int ID){
        Repository repository;
        repository = Creator.createRepository();
        String[] params = {"VACATION","Minsk","Moskow","4","MINIBUS","2019 1 3","2019 5 5","3","Olimp"};
        repository.listObjects.clear();
        repository.addObject(params);
        repository.deleteObject(ID);

        boolean temp = repository.listObjects.isEmpty();

        Assert.assertEquals(temp,false,"creation is correct");
    }


    @DataProvider(name = "correctRead")
    public Object[][] createCorrectDataRead(){
        return
                new Object[][]{
                        {}
                };
    }
    @Test(dataProvider = "correctRead",enabled = true)
    public void readObjectCorrect(){
        Repository repository;
        repository = Creator.createRepository();
        repository.listObjects.clear();
        repository.readObjectsFromFile();
        boolean temp = repository.listObjects.isEmpty();
        Assert.assertEquals(temp,false,"creation is correct");
    }

    @DataProvider(name = "correctSearch")
    public Object[][] createCorrectDataSearch(){
        return
                new Object[][]{
                        {new SearchByType(Type.CRUISE)}
                };
    }
    @Test(dataProvider = "correctSearch",enabled = true)
    public void searchObjectCorrect(Specification specification){
        Repository repository;
        repository = Creator.createRepository();
        repository.listObjects.clear();
        repository.listForSearch.clear();
        repository.readObjectsFromFile();
        repository.searchObject(specification);
        boolean temp = repository.listForSearch.isEmpty();
        Assert.assertEquals(temp,false,"creation is correct");
    }

    @DataProvider(name = "correctSort")
    public Object[][] createCorrectDataSort(){
        return
                new Object[][]{
                        {new SortByDateStart()}
                };
    }
    @Test(dataProvider = "correctSort",enabled = true)
    public void sortObjectCorrect(Comparator<Ticket> comparator){
        Repository repository;

        ArrayList<Ticket> list = new ArrayList<>();
        repository = Creator.createRepository();

        repository.listObjects.clear();
        repository.listForSearch.clear();

        repository.readObjectsFromFile();
        list.addAll(repository.listObjects);
        repository.sortObject(comparator);
        boolean temp = true;
        for(int i = 0; i<list.size();i++){
            if(!list.get(i).equals(repository.listObjects.get(i))){
                temp = false;
                break;
            }
        }
        Assert.assertEquals(temp,false,"creation is correct");
    }
}
