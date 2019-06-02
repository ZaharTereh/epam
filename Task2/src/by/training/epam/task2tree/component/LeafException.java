package by.training.epam.task2tree.component;

public class LeafException extends Exception{
    @Override
    public String getMessage() {
        return "Leaf doesn't contain List";
    }
}
