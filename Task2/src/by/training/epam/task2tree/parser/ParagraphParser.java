package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

public class ParagraphParser implements Parser {
    private Parser nextParser = new SentenceParser();

    @Override
    public Component parse(String paragraph) {
        Component component = new Composite(paragraph, Type.PARAGRAPH);
        String[] sentences = paragraph.split(".");
        for (String string : sentences){
            component.add(nextParser.parse(string));
        }
        return component;
    }
}
