package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements Parser{
    private Parser nextParser = new ParagraphParser();
    private Pattern pattern = Pattern.compile("(\\s{4}|\\t\\t)(\\n|.)+?(\\n{2}|\\r\\n)");
    private Matcher matcher;

    @Override
    public Component parse(String text) {
        Component component = new Composite(Type.TEXT);
        String paragraph ;
        ArrayList<String> paragraphs = new ArrayList<>();
        matcher = pattern.matcher(text);
        while (matcher.find()){
            paragraph = text.substring(matcher.start(),matcher.end());
            paragraphs.add(paragraph);
        }

        for (String string : paragraphs){
            component.add(nextParser.parse(string));
        }
        return component;
    }
}
