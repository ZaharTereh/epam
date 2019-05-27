package by.training.epam.task2tree;

import by.training.epam.task2tree.comparator.SortSentencesBySign;
import by.training.epam.task2tree.controller.Controller;
import by.training.epam.task2tree.controller.Creator;

public class Main {
    public static void main(String[] args) {
        Controller controller = Creator.createController();
        controller.createComponent();
        controller.sort(new SortSentencesBySign('a'));
        System.out.println(controller.getText());
    }
}
