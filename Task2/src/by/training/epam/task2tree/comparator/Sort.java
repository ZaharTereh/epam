package by.training.epam.task2tree.comparator;

import by.training.epam.task2tree.component.Component;
import java.util.Comparator;

public interface Sort extends Comparator<Component>{
    void sort(Component component);
}
