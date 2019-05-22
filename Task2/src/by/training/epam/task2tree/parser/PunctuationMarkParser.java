package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

public class PunctuationMarkParser implements Parser{
    private Parser nextParser = new SymbolParser();
    @Override
    public Component parse(String punktuation_mark) {
        Component component = new Composite(punktuation_mark, Type.PUNCTUATION_MARK);
        return component;
    }
}
