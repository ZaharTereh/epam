package by.training.epam.task3multithreading.controller.command;

import by.training.epam.task3multithreading.service.ChangeDiagonalService;
import by.training.epam.task3multithreading.service.servicefactory.ServiceFactory;

public class ChangeDiagonal implements Command {
    @Override
    public String execute(String request) {
        ChangeDiagonalService service = ServiceFactory.getInstance().getDiagonalService();
        return service.changeDiagonal();
    }
}
