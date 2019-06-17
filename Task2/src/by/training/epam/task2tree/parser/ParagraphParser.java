package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.LeafException;
import by.training.epam.task2tree.component.Type;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class for parsing paragraphs in sentences.
 */
public class ParagraphParser implements Parser {
    /**
     * Next parser in hierarchy.
     */
    private Parser nextParser = new SentenceParser();
    /**
     * Regular expression that help select sentences.
     */
    private Pattern pattern = Pattern.compile("([^\\t])+?(\\.{3}|\\?|!|\\.)");

    /**
     * Method for parsing paragraphs.
     * @param paragraph - paragraphs which will parsed.
     * @return component with parsed sentences.
     */
    @Override
    public Component parse(String paragraph) {
        Component component = new Composite(Type.PARAGRAPH);
        Matcher matcher;
        String sentence ;
        ArrayList<String> sentences = new ArrayList<>();
        matcher = pattern.matcher(paragraph);
        while (matcher.find()){
            sentence = paragraph.substring(matcher.start(),matcher.end());
            sentences.add(sentence);
        }


        for (String string : sentences){
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
