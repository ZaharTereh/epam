package by.training.epam.task2tree.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Creator {

    private  static Controller controller;

    private static final Logger logger = LogManager.getLogger(Creator.class.getName());

    public static Controller createController(){
        if(controller == null){
            controller = new Controller();
            logger.debug("Controller was successful created");
        }
        return controller;
    }
}

