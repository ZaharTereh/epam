package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.LeafException;
import by.training.epam.task2tree.component.Type;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class for parsing punctuation marks in symbols.
 */
public class PunctuationMarkParser implements Parser{
    /**
     * Next parser in hierarchy.
     */
    private Parser nextParser = new SymbolParser();
    /**
     * Regular expression that help select symbols.
     */
    private Pattern pattern = Pattern.compile("\\p{P}");

    /**
     * Method for parsing punctuation marks.
     * @param punctuationMark - punctuation marks which will parsed.
     * @return component with parsed symbols.
     */
    @Override
    public Component parse(String punctuationMark) {
        Component component = new Composite(Type.PUNCTUATION_MARK);
        Matcher matcher;
        String symbol;
        Character c;
        ArrayList<String> symbols = new ArrayList<>();
        matcher = pattern.matcher(punctuationMark);
        while (matcher.find()){
            c = punctuationMark.charAt(matcher.start());
            symbol = c.toString();
            symbols.add(symbol);
        }

        for (String string : symbols){
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
