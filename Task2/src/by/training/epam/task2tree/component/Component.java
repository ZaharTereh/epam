package by.training.epam.task2tree.component;

public interface Component {
    void add(Component component);
    void remove(Component component);
    Component  getChild(int index);
}
