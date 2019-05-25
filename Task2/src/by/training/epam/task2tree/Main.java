package by.training.epam.task2tree;

import by.training.epam.task2tree.parser.TextParser;
import by.training.epam.task2tree.reader.ReaderFiles;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("data/input.txt");
        String text = ReaderFiles.readFile(file);
        System.out.print(text);
        TextParser textParser = new TextParser();
        textParser.parse(text);
    }
}
