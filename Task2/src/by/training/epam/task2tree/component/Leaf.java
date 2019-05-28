package by.training.epam.task2tree.component;
import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;

/**
 * Leaf in Tree-structure model.
 * Last level i Tree.
 */
public class Leaf implements Component {
    /**
     * Information of leaf(symbol).
     */
    private String info;
    /**
     * Type - symbol.
     */
    private Type type = Type.SYMBOL;
    /**
     * Method which return instance on list.
     * @return null, because Leaf doesn't contain list.
     */
    @Override
    public ArrayList<Component> getList() {
        return null;
    }
    /**
     * Method which return its text.
     * @return its symbol.
     */
    @Override
    public String getText() {
        return info;
    }
    /**
     * Method which return Type of component.
     * @return Type.SYMBOL.
     */
    @Override
    public Type getType() {
        return type;
    }
    /**
     * Leaf doesn't contain list.
     * Method doing nothing.
     */
    @Override
    public void add(Component component){
    }

    /**
     * Constructor for this class.
     * @param symbol - information of leaf - its symbol.
     */
    public Leaf(String symbol){
        this.info = symbol;
    }
}
