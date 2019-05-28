package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class for parsing sentences in lexemes.
 */
public class SentenceParser implements Parser {
    /**
     * Next parser in hierarchy.
     */
    private Parser nextParser = new LexemeParser();
    /**
     * Regular expression that help select lexemes.
     */
    private Pattern pattern = Pattern.compile("[^\\s+|\\n]+");
    /**
     * Pattern which include \n in paragraph
     */
    //private Pattern pattern = Pattern.compile("(\\w|\\n|\\p{P})+");
    /**
     * Matcher for work with regular expression.
     */
    private Matcher matcher;
    /**
     * Method for parsing paragraphs.
     * @param sentence - sentences which will parsed.
     * @return component with parsed lexemes.
     */
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
