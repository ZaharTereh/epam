package by.training.epam.task2tree.test;

import by.training.epam.task2tree.comparator.SortLexemeByLength;
import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.Leaf;
import by.training.epam.task2tree.component.Type;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortLexemeByLengthTest {

    private Composite composite1;
    private Composite composite2;
    private Composite composite3;

    private  Composite sentence;

    @BeforeClass
    public void preparationForCompare(){

        composite1 = new Composite(Type.SENTENCE);
        composite1.add(new Leaf("qwerty"));

        composite2 = new Composite(Type.SENTENCE);
        composite2.add(new Leaf("qwert"));

        composite3 = new Composite(Type.SENTENCE);
        composite3.add(new Leaf("qwerty"));

    }
    @DataProvider(name = "correct")
    public Object[][] createCorrectDataCompare(){
        return
                new Object[][]{
                        {composite1,composite3,0},
                        {composite1,composite2,1},
                        {composite2,composite1,-1}
        };
    }
    @Test(description = "test for compare",dataProvider = "correct",enabled = true)
    public void compareCorrect(Component o1,Component o2,int expected){
        Assert.assertEquals(new SortLexemeByLength().compare(o1,o2),expected,"compare is correct");
    }


    @BeforeClass
    public void preparationForSort(){
        sentence = new Composite(Type.SENTENCE);
        sentence.add(new Leaf("bbbb"));
        sentence.add(new Leaf("aaa"));

    }
    @DataProvider(name = "correctSort")
    public Object[][] createCorrectDataSort(){
        return
                new Object[][]{
                        {sentence,"aaabbbb"}
                };
    }
    @Test(description = "test for sort",dataProvider = "correctSort",enabled = true)
    public void sortCorrect(Component o1,String expected){
        new SortLexemeByLength().sort(o1);
        String result = o1.toString();

        Assert.assertEquals(result,expected,"sort is correct");
    }
}
