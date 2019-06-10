package by.training.epam.task3multithreading.controller.command;

import by.training.epam.task3multithreading.bean.Matrix;
import by.training.epam.task3multithreading.service.ViewMatrixService;
import by.training.epam.task3multithreading.service.servicefactory.ServiceFactory;

public class ViewMatrix implements Command {
    @Override
    public String execute(String request) {
        ViewMatrixService view = ServiceFactory.getInstance().getViewMatrixService();
        return view.getMatrixForView();
    }
}
