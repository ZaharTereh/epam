package by.training.epam.task2tree.test;

import by.training.epam.task2tree.comparator.SortParagraphBySentences;
import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.Leaf;
import by.training.epam.task2tree.parser.Type;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortParagraphBySentencesTest {

    private  Composite composite1;
    private Composite composite2;
    private Composite composite3;

    @BeforeClass
    public void preparationForCompare(){

        composite1 = new Composite(Type.SENTENCE);
        composite1.add(new Leaf(""));

        composite2 = new Composite(Type.SENTENCE);

        composite3 = new Composite(Type.SENTENCE);
        composite3.add(new Leaf(""));

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
        Assert.assertEquals(new SortParagraphBySentences().compare(o1,o2),expected,"compare is correct");
    }
}
