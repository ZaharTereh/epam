package by.training.epam.task2tree.component;

import by.training.epam.task2tree.parser.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface-parent for Composite and Leaf.
 */
public interface Component {
    /**
     * Method which return instance on list.
     * @return instance on list.
     */
    List<Component> getList() throws LeafException ;
    /**
     * Method which return Type of component.
     * @return Type of component.
     */
    Type getType();
    /**
     * Method for adding new objects in ArrayList.
     * @param component new object.
     */
    void add(Component component)  throws LeafException ;
}
