package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.component.LeafException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class for parsing text in paragraphs.
 */
public class TextParser implements Parser{
    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(TextParser.class.getName());
    /**
     * Next parser in hierarchy.
     */
    private Parser nextParser = new ParagraphParser();
    /**
     * Regular expression that help select paragraphs.
     */
    private Pattern pattern = Pattern.compile("(\\s{4}|\\t\\t)(\\n|.)+?(\\n{2}|\\r\\n)");

    /**
     * Method for parsing text.
     * @param text - text which will parsed.
     * @return component with parsed paragraphs.
     */
    @Override
    public Component parse(String text) {
        logger.debug("The text starts to parse");
        Component component = new Composite(Type.TEXT);
        Matcher matcher;
        String paragraph ;
        ArrayList<String> paragraphs = new ArrayList<>();
        matcher = pattern.matcher(text);
        while (matcher.find()){
            paragraph = text.substring(matcher.start(),matcher.end());
            paragraphs.add(paragraph);
        }

        for (String string : paragraphs){
            try {
            component.add(nextParser.parse(string));
        }
        catch (LeafException ex){
            ex.getMessage();
        }
        }
        logger.debug("Parsing was successful");
        return component;
    }
}
