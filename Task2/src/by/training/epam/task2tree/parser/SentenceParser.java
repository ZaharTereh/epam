package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private Parser nextParser = new LexemeParser();
    private Pattern pattern = Pattern.compile("[^\\s+|\\n]+");
    private Matcher matcher;

    @Override
    public Component parse(String sentence) {
        Component component = new Composite(Type.SENTENCE);
        String lexeme ;
        ArrayList<String> lexemes = new ArrayList<>();
        matcher = pattern.matcher(sentence);
        while (matcher.find()){
            lexeme = sentence.substring(matcher.start(),matcher.end());
            lexemes.add(lexeme);
        }
        for (String string : lexemes){
            component.add(nextParser.parse(string));
        }
        return component;
    }
}
