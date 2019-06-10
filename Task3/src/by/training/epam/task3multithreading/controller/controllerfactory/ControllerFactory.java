package by.training.epam.task3multithreading.controller.controllerfactory;

import by.training.epam.task3multithreading.controller.Controller;

public class ControllerFactory {
    public static ControllerFactory instance = new ControllerFactory();
    private final Controller controller = new Controller();

    public static ControllerFactory getInstance() {
        return instance;
    }
    public Controller getController() {
        return controller;
    }

    private ControllerFactory(){}
}
