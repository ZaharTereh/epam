package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Leaf;
/**
 * Class for create leaf.
 */
public class SymbolParser implements Parser {
    /**
     * Method for create leaf.
     * @param symbol - symbol of leaf.
     * @return component - leaf.
     */
    @Override
    public Component parse(String symbol) {
        return new Leaf(symbol);
    }
}
