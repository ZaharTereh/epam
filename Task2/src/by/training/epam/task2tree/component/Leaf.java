package by.training.epam.task2tree.component;
import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;

public class Leaf implements Component {
    private String info;
    private Type type = Type.SYMBOL;

    @Override
    public ArrayList<Component> getList() {
        return null;
    }
    @Override
    public String getText() {
        return info;
    }
    @Override
    public Type getType() {
        return type;
    }
    @Override
    public void add(Component component){
    }

    public Leaf(String symbol){
        this.info = symbol;
    }
}
