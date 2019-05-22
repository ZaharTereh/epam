package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

public class SentenceParser implements Parser {
    private Parser nextParser = new LexemeParser();

    @Override
    public Component parse(String sentence) {
        Component component = new Composite(sentence, Type.SENTENCE);
        String[] lexemes = sentence.split(" ");
        for (String string : lexemes){
            component.add(nextParser.parse(string));
        }
        return component;
    }
}
