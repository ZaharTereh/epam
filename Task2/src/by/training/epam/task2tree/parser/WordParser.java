package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.LeafException;
import by.training.epam.task2tree.component.Type;

import java.util.ArrayList;
/**
 * Class for parsing words in symbols.
 */
public class WordParser implements Parser {
    /**
     * Next parser in hierarchy.
     */
    private Parser nextParser = new SymbolParser();
    /**
     * Method for parsing paragraphs.
     * @param word - words which will parsed.
     * @return component with parsed symbols.
     */
    @Override
    public Component parse(String word) {
        Component component = new Composite(Type.WORD);
        int size = word.length();
        ArrayList<String> symbols = new ArrayList<>();
        Character c;
        for(int i=0; i<size; i++){
            c = word.charAt(i);
            symbols.add(c.toString());
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
