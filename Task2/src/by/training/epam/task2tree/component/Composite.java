package by.training.epam.task2tree.component;

import by.training.epam.task2tree.enm.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

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
    public ArrayList<Component> getList() {
        return components;
    }
    /**
     * Method which return its text.
     * @return its text.
     */
    @Override
    public String getText() {
        String result = "";
        for(Component component:components){
            if(component.getType()==Type.LEXEME) {
                result += component.getText()+" ";
            }else if(component.getType()==Type.PARAGRAPH){
                result += "\t\t"+component.getText()+"\n\n";
            }else {
                result += component.getText();
            }
        }
        return result;
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
     * Constructor for this class.
     * @param type - type of new object.
     */
    public Composite(Type type){
        this.type = type;
    }

}
