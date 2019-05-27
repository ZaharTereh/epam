package by.training.epam.task2tree.comparator;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.enm.Type;


public class SortParagraphBySentences implements Sort {
    @Override
    public int compare(Component o1, Component o2) {

        Integer temp1 = o1.getList().size();
        Integer temp2 = o2.getList().size();

        return temp1.compareTo(temp2);
    }

    @Override
    public void sort(Component component) {
        if (component.getType() == Type.TEXT) {
            component.getList().sort(this);
        } else {
            for (Component temp : component.getList()) {
                sort(temp);
            }
        }
    }
}
