package by.training.epam.task2tree.test;

import by.training.epam.task2tree.comparator.SortLexemeByLength;
import by.training.epam.task2tree.comparator.SortParagraphBySentences;
import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.Leaf;
import by.training.epam.task2tree.enm.Type;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortParagraphBySentencesTest {
    @DataProvider(name = "correct")
    public Object[][] createCorrectDataCompare(){

        Composite composite1 = new Composite(Type.SENTENCE);
        composite1.add(new Leaf(""));

        Composite composite2 = new Composite(Type.SENTENCE);

        Composite composite3 = new Composite(Type.SENTENCE);
        composite3.add(new Leaf(""));

        return
                new Object[][]{
                        {composite1,composite3,0},
                        {composite1,composite2,1},
                        {composite2,composite1,-1}
                };
    }
    @Test(description = "test for compare",dataProvider = "correct",enabled = true)
    public void compareCorrect(Component o1,Component o2,int expected){
        int result = new SortParagraphBySentences().compare(o1,o2);
        Assert.assertEquals(result,expected,"compare is correct");
    }
}
