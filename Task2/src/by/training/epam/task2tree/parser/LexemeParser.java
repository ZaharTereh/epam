package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.LeafException;
import by.training.epam.task2tree.component.Type;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for parsing lexemes in words and punctuation marks.
 */
public class LexemeParser implements Parser {
    /**
     * Next parser in hierarchy.
     */
    private Parser nextWordParser = new WordParser();
    /**
     * Next parser in hierarchy.
     */
    private Parser nextPunctuationParser = new PunctuationMarkParser();
    /**
     * Regular expression that help select words and punctuation marks.
     */
    private Pattern pattern = Pattern.compile("\\p{P}+$");

    /**
     * Class which help parse.
     */
    private class Element {
        private Type type;
        private String info;
    }

    /**
     * Method for parsing lexemes.
     * @param lexeme - lexeme which will parsed.
     * @return component with parsed words and punctuation marks.
     */
    @Override
    public Component parse(String lexeme) {
        Component component = new Composite(Type.LEXEME);
        Matcher matcher;


        Element punctuationMark = new Element();
        Element word = new Element();
        ArrayList<Element> partsOfLexemes = new ArrayList<>();
        matcher = pattern.matcher(lexeme);
        if (matcher.find()) {
            punctuationMark.type = Type.PUNCTUATION_MARK;
            punctuationMark.info = lexeme.substring(matcher.start(),lexeme.length());
            word.type = Type.WORD;
            word.info = lexeme.substring(0,matcher.start());
            partsOfLexemes.add(word);
            partsOfLexemes.add(punctuationMark);
        } else {
            word.type = Type.WORD;
            word.info = lexeme;
            partsOfLexemes.add(word);
        }

        for (Element element : partsOfLexemes){
            if(element.type == Type.WORD) {
                try {
                    component.add(nextWordParser.parse(element.info));
                }
                catch (LeafException ex){
                    ex.getMessage();
                }
            }else {
                try {
                    component.add(nextPunctuationParser.parse(element.info));
                }
                catch (LeafException ex){
                    ex.getMessage();
                }
            }
        }
        return component;
    }
}
