package by.training.epam.task3multithreading.controller.command;

import by.training.epam.task3multithreading.service.ChangeDiagonalService;
import by.training.epam.task3multithreading.service.ServiceException;
import by.training.epam.task3multithreading.service.servicefactory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class ChangeDiagonal implements Command {
    private static final Logger logger = LogManager.getLogger(ChangeDiagonal.class.getName());
    private HashMap<Boolean,String> map = new HashMap<>();
    {
        map.put(true,"Diagonal was changed");
        map.put(false,"Diagonal wasn't changed");
    }

    @Override
    public String execute(String request) {
        try {
            ChangeDiagonalService service = ServiceFactory.getInstance().getDiagonalService();
            service.changeDiagonal();
            return map.get(true);
        }catch (ServiceException ex){
            logger.error(ex.getMessage());
            return map.get(false);
        }

    }
}
