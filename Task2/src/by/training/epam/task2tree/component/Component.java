package by.training.epam.task2tree.component;

import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;

/**
 * Interface-parent for Composite and Leaf.
 */
public interface Component {
    /**
     * Method which return instance on list.
     * @return instance on list.
     */
    ArrayList<Component> getList();
    /**
     * Method which return Type of component.
     * @return Type of component.
     */
    Type getType();
    /**
     * Method for adding new objects in ArrayList.
     * @param component new object.
     */
    void add(Component component);
    /**
     * Method which return its text.
     * @return its text.
     */
    String  getText();
}
