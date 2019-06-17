package by.training.epam.task2tree.test;

import by.training.epam.task2tree.comparator.SortSentencesBySign;
import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.Leaf;
import by.training.epam.task2tree.component.Type;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortSentencesBySignTest {
    private Composite composite1;
    private Composite composite2;
    private Composite composite3;

    private Composite paragraph;
    private Composite sentence1;
    private Composite sentence2;

    @BeforeClass
    public void preparationForCompare(){
        composite1 = new Composite(Type.SENTENCE);
        composite1.add(new Leaf("qqqqq AA qqqqq"));

        composite2 = new Composite(Type.SENTENCE);
        composite2.add(new Leaf("qqqqq A qqqqq"));

        composite3 = new Composite(Type.SENTENCE);
        composite3.add(new Leaf("qqqqq AA qqqqq"));
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
        Assert.assertEquals(new SortSentencesBySign('A').compare(o1,o2),expected,"compare is correct");
    }

    @BeforeClass
    public void preparationForSort(){
        paragraph = new Composite(Type.PARAGRAPH);

        sentence1 = new Composite(Type.SENTENCE);
        sentence2 = new Composite(Type.SENTENCE);

        sentence1.add(new Leaf("xxx AAA xxx"));
        sentence2.add(new Leaf("xxx AA xxx "));

        paragraph.add(sentence1);
        paragraph.add(sentence2);
    }
    @DataProvider(name = "correctSort")
    public Object[][] createCorrectDataSort(){
        return
                new Object[][]{
                        {paragraph,"xxx AA xxx xxx AAA xxx"}
                };
    }
    @Test(description = "test for sort",dataProvider = "correctSort",enabled = true)
    public void sortCorrect(Component o1,String expected){
        new SortSentencesBySign('A').sort(o1);
        String result = o1.toString();

        Assert.assertEquals(result,expected,"sort is correct");
    }
}
