package by.training.epam.task2tree.test;

import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.Leaf;
import by.training.epam.task2tree.enm.Type;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompositeTest {
    @DataProvider(name = "correct")
    public Object[][] createCorrectDataAdd(){
        return
                new Object[][]{
                        {false},
                };
    }
    @Test(description = "test for add",dataProvider = "correct",enabled = true)
    public void addCorrect(boolean expected){

        Composite composite = new Composite(Type.SENTENCE);
        composite.add(new Leaf("qwerty"));

        boolean result = composite.getList().isEmpty();

        Assert.assertEquals(result,expected,"compare is correct");
    }

    @DataProvider(name = "correctGetText")
    public Object[][] createCorrectDataGetText(){
        Composite composite = new Composite(Type.SENTENCE);
        composite.add(new Leaf("info"));
        return
                new Object[][]{
                        {composite,"info",true},
                };
    }
    @Test(description = "test for method getText",dataProvider = "correctGetText",enabled = true)
    public void getTextCorrect(Composite composite,String text,boolean expected){

        String text1 = composite.getText();
        boolean result = text.equals(text1);

        Assert.assertEquals(result,expected,"compare is correct");
    }

    @DataProvider(name = "correctGetType")
    public Object[][] createCorrectDataGetType(){
        Composite composite = new Composite(Type.SENTENCE);
        return
                new Object[][]{
                        {composite,Type.SENTENCE,true},
                };
    }
    @Test(description = "test for method getType",dataProvider = "correctGetType",enabled = true)
    public void getTypeCorrect(Composite composite,Type type,boolean expected){

        boolean result = composite.getType().equals(type);

        Assert.assertEquals(result,expected,"compare is correct");
    }
}
