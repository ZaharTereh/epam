package by.training.epam.task2tree.component;
import by.training.epam.task2tree.parser.Type;

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
    public ArrayList<Component> getList() throws LeafException {
        throw new LeafException();
    }
    /**
     * Method which return its text.
     * @return its symbol.
     */
    @Override
    public String toString() {
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
    public void add(Component component) throws LeafException {
        throw new LeafException();
    }
    /**
     * Override equals method.
     * @return true if equals, false if not equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leaf leaf = (Leaf) o;

        if (info != null ? !info.equals(leaf.info) : leaf.info != null) return false;
        return type == leaf.type;
    }
    /**
     * Override hashcode method.
     * @return int number.
     */
    @Override
    public int hashCode() {
        int result = info != null ? info.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    /**
     * Constructor for this class.
     * @param symbol - information of leaf - its symbol.
     */
    public Leaf(String symbol){
        this.info = symbol;
    }
}
