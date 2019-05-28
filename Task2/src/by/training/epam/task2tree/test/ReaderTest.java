package by.training.epam.task2tree.test;

import by.training.epam.task2tree.reader.ReaderFiles;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class ReaderTest {
    @DataProvider(name = "correct")
    public Object[][] createCorrectDataRead(){
        String text ="\t\tIt has survived not only five centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n" +
                "\t\tIt is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
                "more-or-less normal distribution of letters, as opposed to using 'Content here, content\n" +
                "here', making it look like readable English.\n" +
                "\n" +
                "\t\tIt is a established fact that a reader will be of a page when looking at its\n" +
                "layout.\n" +
                "\n" +
                "\t\tBye.\n" +
                "\n";
        return
                new Object[][]{
                        {true,text},
                };
    }
    @Test(description = "test for read from file",dataProvider = "correct",enabled = true)
    public void readCorrect(boolean expected,String text){

        String textFromFile = ReaderFiles.readFile(new File("data/input.txt"));
        boolean result = textFromFile.equals(text);

        Assert.assertEquals(result,expected,"compare is correct");
    }
}
