package by.training.epam.task2tree.controller;

import by.training.epam.task2tree.comparator.Sort;
import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.parser.TextParser;
import by.training.epam.task2tree.reader.ReaderFiles;
import by.training.epam.task2tree.writer.WriterFiles;

import java.io.File;

public class Controller {
    private Component component;

    public void createComponent() {
        File file = new File("data/input.txt");
        String text = ReaderFiles.readFile(file);
        component = new TextParser().parse(text);
    }

    public String getText() {
        return component.getText();
    }

    public void writeTextInFile() {
        WriterFiles.writeInFile(getText());
    }

    public void sort(Sort comparator){
        comparator.sort(component);
    }

    Controller(){
    }
}
