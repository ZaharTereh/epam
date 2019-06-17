package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.LeafException;
import by.training.epam.task2tree.component.Type;

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
     * If include \n in paragraph use "(\\w|\\n|\\p{P})+".
     */
    private Pattern pattern = Pattern.compile("[^\\s+|\\n]+");
    /**
     * Method for parsing paragraphs.
     * @param sentence - sentences which will parsed.
     * @return component with parsed lexemes.
     */
    @Override
    public Component parse(String sentence) {
        Component component = new Composite(Type.SENTENCE);
        Matcher matcher;
        String lexeme ;
        ArrayList<String> lexemes = new ArrayList<>();
        matcher = pattern.matcher(sentence);
        while (matcher.find()){
            lexeme = sentence.substring(matcher.start(),matcher.end());
            lexemes.add(lexeme);
        }
        for (String string : lexemes){
            try {
            component.add(nextParser.parse(string));
        }
        catch (LeafException ex){
            ex.getMessage();
        }
        }
        return component;
    }
}
