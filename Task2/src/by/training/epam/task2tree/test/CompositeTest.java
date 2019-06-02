package by.training.epam.task2tree.test;

import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.Leaf;
import by.training.epam.task2tree.parser.Type;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompositeTest {

    private Composite composite;
    private Composite composite2;
    private Composite composite3;

    @BeforeClass
    public void preparationForAdd(){
        composite = new Composite(Type.SENTENCE);
        composite.add(new Leaf("qwerty"));
    }
    @Test(description = "test for add",enabled = true)
    public void addCorrect(){
        Assert.assertNotNull(composite.getList(),"Instance is not NULL");
    }

    @BeforeClass
    public void preparationForGetText(){
        composite2 = new Composite(Type.SENTENCE);
        composite2.add(new Leaf("info"));
    }
    @DataProvider(name = "correctGetText")
    public Object[][] createCorrectDataGetText(){
        return
                new Object[][]{
                        {composite2,"info"},
                };
    }
    @Test(description = "test for method getText",dataProvider = "correctGetText",enabled = true)
    public void getTextCorrect(Composite composite,String text){
        String textResult = composite.toString();
        Assert.assertEquals(textResult,text,"Text is correct");
    }

    @BeforeClass
    public void preparationForGetType(){
        composite3 = new Composite(Type.SENTENCE);
    }
    @DataProvider(name = "correctGetType")
    public Object[][] createCorrectDataGetType(){
        return
                new Object[][]{
                        {composite3,Type.SENTENCE},
                };
    }
    @Test(description = "test for method getType",dataProvider = "correctGetType",enabled = true)
    public void getTypeCorrect(Composite composite,Type type){
        Assert.assertEquals(composite.getType(),type,"Type is correct");
    }
}
