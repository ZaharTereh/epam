package by.training.epam.task2tree.comparator;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.enm.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

/**
 * Class which consist methods for sorting lexemes by length.
 */
public class SortLexemeByLength implements Sort {
    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(SortLexemeByLength.class.getName());
    /**
     * Rule how to compare two objects.
     * @param o1 - first object.
     * @param o2 - second object.
     * @return -1 if less; 0 if equal; 1 if bigger.
     */
    @Override
    public int compare(Component o1, Component o2) {
        Integer length1 = o1.getText().length();
        Integer length2 = o2.getText().length();
        return length1.compareTo(length2);
    }
    /**
     * Method for sorting us composite.
     * @param component - which are sorted.
     */
    @Override
    public void sort(Component component) {
        if (component.getType() == Type.SENTENCE) {
            component.getList().sort(this);
        } else {
            for (Component temp : component.getList()) {
                sort(temp);
            }
        }
        logger.debug("Sort was successful!");
    }
}
