package by.training.epam.task4xml.controller.command;

import by.training.epam.task4xml.service.servicefactory.ServiceFactory;

import java.util.List;

public class StAXCommand implements Command {
    @Override
    public List<List<String>> execute(String fileName) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        return serviceFactory.getStax().parse(fileName);
    }
}
