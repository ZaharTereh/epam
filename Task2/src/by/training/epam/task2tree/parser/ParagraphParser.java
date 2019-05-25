package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {
    private Parser nextParser = new SentenceParser();
    private Pattern pattern = Pattern.compile("([^\\t])+?(\\.{3}|\\?|!|\\.)");
    private Matcher matcher;

    @Override
    public Component parse(String paragraph) {
        Component component = new Composite(Type.PARAGRAPH);
        String sentence ;
        ArrayList<String> sentences = new ArrayList<>();
        matcher = pattern.matcher(paragraph);
        while (matcher.find()){
            sentence = paragraph.substring(matcher.start(),matcher.end());
            sentences.add(sentence);
        }


        for (String string : sentences){
            component.add(nextParser.parse(string));
        }

        return component;

    }
}
