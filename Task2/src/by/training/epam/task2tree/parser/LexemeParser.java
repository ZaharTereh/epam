package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements Parser {
    private Parser nextWordParser = new WordParser();
    private Parser nextPunctuationParser = new PunctuationMarkParser();
    private Pattern pattern = Pattern.compile("\\p{P}+$");
    private Matcher matcher;

    private class Element {
        private Type type;
        private String info;
    }

    @Override
    public Component parse(String lexeme) {
        Component component = new Composite(Type.LEXEME);

        Element punctuation_mark = new Element();
        Element word = new Element();
        ArrayList<Element> partsOfLexemes = new ArrayList<>();
        matcher = pattern.matcher(lexeme);
        if (matcher.find()) {
            punctuation_mark.type = Type.PUNCTUATION_MARK;
            punctuation_mark.info = lexeme.substring(matcher.start(),lexeme.length());
            word.type = Type.WORD;
            word.info = lexeme.substring(0,matcher.start());
            partsOfLexemes.add(word);
            partsOfLexemes.add(punctuation_mark);
        } else {
            word.type = Type.WORD;
            word.info = lexeme;
            partsOfLexemes.add(word);
        }

        for (Element element : partsOfLexemes){
            if(element.type == Type.WORD) {
                component.add(nextWordParser.parse(element.info));
            }else {
                component.add(nextPunctuationParser.parse(element.info));
            }
        }
        return component;
    }
}
