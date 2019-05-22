package by.training.epam.task2tree.component;
import by.training.epam.task2tree.enm.Type;

public class Leaf implements Component {
    private String into;
    private Type type;

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

    public Leaf(String symbol){
        this.into = symbol;
        this.type = Type.SYMBOL;
    }
}
