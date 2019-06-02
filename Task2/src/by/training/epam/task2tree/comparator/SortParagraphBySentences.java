package by.training.epam.task2tree.comparator;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.LeafException;
import by.training.epam.task2tree.parser.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Class which consist methods for sorting paragraphs by sentences.
 */
public class SortParagraphBySentences implements Sort {
    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(SortParagraphBySentences.class.getName());
    /**
     * Rule how to compare two objects.
     * @param o1 - first object.
     * @param o2 - second object.
     * @return -1 if less; 0 if equal; 1 if bigger.
     */
    @Override
    public int compare(Component o1, Component o2) {
        int temp1 = 0;
        int temp2 = 0;
        try {
            temp1 = o1.getList().size();
            temp2 = o2.getList().size();
        }
        catch (LeafException ex){
            ex.getMessage();
        }
        return temp1 - temp2;
    }
    /**
     * Method for sorting us composite.
     * @param component - which are sorted.
     */
    @Override
    public void sort(Component component) {
        try {
        if (component.getType() == Type.TEXT) {
            component.getList().sort(this);
            logger.debug("Sort was successful!");
        } else {
            for (Component temp : component.getList()) {
                sort(temp);
            }
        }
        }
        catch (LeafException ex){
        ex.getMessage();
    }
    }
}
