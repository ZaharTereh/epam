package by.training.epam.task2tree.test;

import by.training.epam.task2tree.comparator.SortLexemeByLength;
import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.Leaf;
import by.training.epam.task2tree.enm.Type;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortLexemeByLengthTest {

    @DataProvider(name = "correct")
    public Object[][] createCorrectDataCompare(){

        Composite composite1 = new Composite(Type.SENTENCE);
        composite1.add(new Leaf("qwerty"));

        Composite composite2 = new Composite(Type.SENTENCE);
        composite2.add(new Leaf("qwert"));

        Composite composite3 = new Composite(Type.SENTENCE);
        composite3.add(new Leaf("qwerty"));

        return
                new Object[][]{
                        {composite1,composite3,0},
                        {composite1,composite2,1},
                        {composite2,composite1,-1}
        };
    }
    @Test(description = "test for compare",dataProvider = "correct",enabled = true)
    public void compareCorrect(Component o1,Component o2,int expected){
        int result = new SortLexemeByLength().compare(o1,o2);
        Assert.assertEquals(result,expected,"compare is correct");
    }

    @DataProvider(name = "correctSort")
    public Object[][] createCorrectDataSort(){

        Composite composite1 = new Composite(Type.SENTENCE);
        composite1.add(new Leaf("bbbb"));
        composite1.add(new Leaf("aaa"));

        return
                new Object[][]{
                        {composite1,"aaabbbb"}
                };
    }
    @Test(description = "test for sort",dataProvider = "correctSort",enabled = true)
    public void sortCorrect(Component o1,String expected){
        new SortLexemeByLength().sort(o1);
        String result = o1.getText();
        boolean temp = result.equals(expected);

        Assert.assertEquals(temp,true,"sort is correct");
    }
}
