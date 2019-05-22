package by.training.epam.task2tree.component;

import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;

public class Composite implements  Component{
    private Type type;
    private ArrayList<Component> components;

    @Override
    public void add(Component component) {
        components.add(component);
    }
    @Override
    public void remove(Component component) {
        components.remove(component);
    }
    @Override
    public Component getChild(int index) {
       return components.get(index);
    }

    public Type getType() {
        return type;
    }

    public Composite(String info,Type type){
        this.type = type;
    }

}
