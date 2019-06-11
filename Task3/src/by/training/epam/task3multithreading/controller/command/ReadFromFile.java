package by.training.epam.task3multithreading.controller.command;

import by.training.epam.task3multithreading.service.ReadMatrixService;
import by.training.epam.task3multithreading.service.servicefactory.ServiceFactory;

import java.util.HashMap;

public class ReadFromFile implements Command{
    private HashMap<Boolean,String> map = new HashMap<>();
    {
        map.put(true,"Reading was successful");
        map.put(false,"Reading wasn't successful");
    }

    @Override
    public String execute(String request) {
        ReadMatrixService service = ServiceFactory.getInstance().getReadMatrixService();
        return map.get(service.readMatrixISCorrectly());
    }
}
