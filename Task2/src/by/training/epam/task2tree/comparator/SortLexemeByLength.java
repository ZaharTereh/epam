package by.training.epam.task2tree.comparator;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.enm.Type;

public class SortLexemeByLength implements Sort {
    @Override
    public int compare(Component o1, Component o2) {
        Integer length1 = o1.getText().length();
        Integer length2 = o2.getText().length();
        return length1.compareTo(length2);
    }

    @Override
    public void sort(Component component) {
        if (component.getType() == Type.SENTENCE) {
            component.getList().sort(this);
        } else {
            for (Component temp : component.getList()) {
                sort(temp);
            }
        }
    }
}
