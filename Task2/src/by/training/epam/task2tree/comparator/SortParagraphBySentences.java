package by.training.epam.task2tree.comparator;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.enm.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        Integer temp1 = o1.getList().size();
        Integer temp2 = o2.getList().size();

        return temp1.compareTo(temp2);
    }
    /**
     * Method for sorting us composite.
     * @param component - which are sorted.
     */
    @Override
    public void sort(Component component) {
        if (component.getType() == Type.TEXT) {
            component.getList().sort(this);
        } else {
            for (Component temp : component.getList()) {
                sort(temp);
            }
        }
        logger.debug("Sort was successful!");
    }
}
