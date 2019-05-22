package by.training.epam.task2tree.component;

public class Leaf implements Component {
    private String into;

    @Override
    public void add(Component component){
    }
    @Override
    public void remove(Component component){
    }
    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
