package by.training.epam.task2tree.controller;

import by.training.epam.task2tree.comparator.Sort;
import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.parser.TextParser;
import by.training.epam.task2tree.reader.ReaderFiles;
import by.training.epam.task2tree.writer.WriterFiles;

import java.io.File;

/**
 * Class for manage Tree-Component.
 */
public class Controller {
    /**
     * Tree-Component.
     */
    private Component component;
    /**
     * Method for read text from file and parse this text in Tree.
     */
    public void createComponent() {
        File file = new File("data/input.txt");
        String text = ReaderFiles.readFile(file);
        component = new TextParser().parse(text);
    }
    /**
     * Method for collect text from Tree.
     * @return String text.
     */
    public String getText() {
        return component.getText();
    }
    /**
     * Method for write Tree in file.
     */
    public void writeTextInFile() {
        WriterFiles.writeInFile(getText());
    }
    /**
     * Method for sort Tree.
     */
    public void sort(Sort comparator){
        comparator.sort(component);
    }

    Controller(){
    }
}
