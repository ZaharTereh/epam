package by.training.epam.task2tree.component;

import by.training.epam.task2tree.enm.Type;

public interface Component {
    Type getType();
    void add(Component component);
    void remove(Component component);
    Component  getChild(int index);
}
