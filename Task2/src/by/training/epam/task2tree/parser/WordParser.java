package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

public class WordParser implements Parser {
    private Parser nextParser = new SymbolParser();

    @Override
    public Component parse(String word) {
        Component component = new Composite(word, Type.WORD);
        return component;
    }
}
