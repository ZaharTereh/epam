package by.training.epam.task2tree.component;

import by.training.epam.task2tree.parser.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class-entity.Object of this class contain list of objects like THIS,but have another type.
 * This something like Tree.
 * The last level in this model is Leaf.
 */
public class Composite implements  Component{
    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(Composite.class.getName());
    /**
     * Type of this object.
     */
    private Type type;
    /**
     * List of objects like this,but another type.
     */
    private ArrayList<Component> components = new ArrayList<>();
    /**
     * Method which return instance on list.
     * @return instance on list.
     */
    @Override
    public List<Component> getList() {
        /*ArrayList<Component> list = new ArrayList<>();
        list.addAll(components);
        return list;*/
        return components;
    }
    /**
     * Method which return its text.
     * @return its text.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Component component:components){
            if(component.getType()==Type.LEXEME) {
                result.append(component.toString()+" ");
            }else if(component.getType()==Type.PARAGRAPH){
                result.append("\t\t"+component.toString()+"\n\n");
            }else {
                result.append(component.toString());
            }
        }
        return result.toString();
    }
    /**
     * Method for adding new objects in ArrayList.
     * @param component new object.
     */
    @Override
    public void add(Component component) {
        components.add(component);
        logger.debug("Object was successfully added!");
    }
    /**
     * Method which return Type of component.
     * @return Type of component.
     */
    @Override
    public Type getType() {
        return type;
    }
    /**
     * Override equals method.
     * @return true if equals, false if not equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composite composite = (Composite) o;

        if (type != composite.type) return false;
        return components != null ? components.equals(composite.components) : composite.components == null;
    }
    /**
     * Override hashcode method.
     * @return int number.
     */
    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (components != null ? components.hashCode() : 0);
        return result;
    }

    /**
     * Constructor for this class.
     * @param type - type of new object.
     */


    public Composite(Type type){
        this.type = type;
    }

}
