package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

public class LexemeParser implements Parser {
    private Parser nextParser = new LexemeParser();
    @Override
    public Component parse(String lexeme) {
        Component component = new Composite(lexeme, Type.LEXEME);
        String[] lexemes = lexeme.split(" ");
        for (String string : lexemes){
            component.add(nextParser.parse(string));
        }
        return component;
    }
}
