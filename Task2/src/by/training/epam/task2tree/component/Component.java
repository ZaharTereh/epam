package by.training.epam.task2tree.component;

import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;

public interface Component {

    ArrayList<Component> getList();
    Type getType();
    void add(Component component);
    String  getText();
}
