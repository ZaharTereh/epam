package by.training.epam.task3multithreading.controller.command;

import by.training.epam.task3multithreading.service.ReadMatrixService;
import by.training.epam.task3multithreading.service.servicefactory.ServiceFactory;

public class ReadFromFile implements Command{

    @Override
    public String execute(String request) {
        ReadMatrixService service = ServiceFactory.getInstance().getReadMatrixService();
        return service.readMatrix();
    }
}
