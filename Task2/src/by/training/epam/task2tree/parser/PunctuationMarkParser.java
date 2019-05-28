package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

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
     * Matcher for work with regular expression.
     */
    private Matcher matcher;
    /**
     * Method for parsing punctuation marks.
     * @param punctuation_mark - punctuation marks which will parsed.
     * @return component with parsed symbols.
     */
    @Override
    public Component parse(String punctuation_mark) {
        Component component = new Composite(Type.PUNCTUATION_MARK);
        String symbol;
        Character c;
        ArrayList<String> symbols = new ArrayList<>();
        matcher = pattern.matcher(punctuation_mark);
        while (matcher.find()){
            c = punctuation_mark.charAt(matcher.start());
            symbol = c.toString();
            symbols.add(symbol);
        }

        for (String string : symbols){
            component.add(nextParser.parse(string));
        }
        return component;
    }
}
