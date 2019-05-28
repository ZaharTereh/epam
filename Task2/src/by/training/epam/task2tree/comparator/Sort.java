package by.training.epam.task2tree.comparator;

import by.training.epam.task2tree.component.Component;
import java.util.Comparator;

/**
 * Parent of classes for sorting.
 */
public interface Sort extends Comparator<Component>{
    /**
     * Method for sorting us composite.
     * @param component - which are sorted.
     */
    void sort(Component component);
}
