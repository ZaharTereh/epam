package by.training.epam.task2tree.component;

import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;

public class Composite implements  Component{
    private Type type;
    private ArrayList<Component> components = new ArrayList<>();


    @Override
    public ArrayList<Component> getList() {
        return components;
    }

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
    @Override
    public void add(Component component) {
        components.add(component);
    }
    @Override
    public Type getType() {
        return type;
    }

    public Composite(Type type){
        this.type = type;
    }

}
