package by.training.epam.task4xml.controller.controllerfactory;

import by.training.epam.task4xml.controller.Controller;

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
