package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

public class TextParser implements Parser{
    private Parser nextParser = new ParagraphParser();

    @Override
    public Component parse(String text) {
        Component component = new Composite(text, Type.TEXT);
        String[] paragraphs = text.split("\n\n");
        for (String string : paragraphs){
            component.add(nextParser.parse(string));
        }
        return component;
    }
}
