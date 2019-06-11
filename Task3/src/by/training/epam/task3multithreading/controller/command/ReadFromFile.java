package by.training.epam.task3multithreading.controller.command;

import by.training.epam.task3multithreading.service.ReadMatrixService;
import by.training.epam.task3multithreading.service.ServiceException;
import by.training.epam.task3multithreading.service.servicefactory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class ReadFromFile implements Command{
    private static final Logger logger = LogManager.getLogger(ReadFromFile.class.getName());
    private HashMap<Boolean,String> map = new HashMap<>();
    {
        map.put(true,"Reading was successful");
        map.put(false,"Reading wasn't successful");
    }

    @Override
    public String execute(String request) {
        try {
            ReadMatrixService service = ServiceFactory.getInstance().getReadMatrixService();
            return map.get(service.readMatrixISCorrectly());
        }catch (ServiceException ex){
            logger.error(ex.getMessage());
            return map.get(false);
        }

    }
}
