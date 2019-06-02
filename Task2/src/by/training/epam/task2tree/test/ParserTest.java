package by.training.epam.task2tree.test;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.controller.Controller;
import by.training.epam.task2tree.parser.TextParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParserTest {

    private String text;
    private Component component;

    @BeforeClass
    public void preparationForParse(){
        text ="\t\tIt has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n" +
                "\n" +
                "\t\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. \n" +
                "\n" +
                "\t\tIt is a established fact that a reader will be of a page when looking at its layout. \n" +
                "\n" +
                "\t\tBye. \n" +
                "\n";

    }
    @DataProvider(name = "correct")
    public Object[][] createCorrectDataParse(){
        return
                new Object[][]{
                        {text},
                };
    }
    @Test(description = "test for parsers",dataProvider = "correct",enabled = true)
    public void parseCorrect(String text){
        component = new TextParser().parse(text);
        Assert.assertEquals(component.toString(),text,"parsing is correct");
    }
}
