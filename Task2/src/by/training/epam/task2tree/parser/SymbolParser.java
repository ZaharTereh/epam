package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Leaf;

public class SymbolParser implements Parser {
    @Override
    public Component parse(String symbol) {
        return new Leaf(symbol);
    }
}
