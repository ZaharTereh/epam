package by.training.epam.task2tree;

import by.training.epam.task2tree.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        controller.createComponent();
        System.out.println(controller.getText());
    }
}
