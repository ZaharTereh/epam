package by.training.epam.task2tree.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class-creator which create object of Controller.
 */
public class Creator {
    /**
     * Instance in object-controller(for SingleTon)
     */
    private  static Controller controller;
    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(Creator.class.getName());
    /**
     * Method which create controller(with SingleTon pattern).
     * @return instance in object-controller or create
     * new object-controller.
     */
    public static Controller createController(){
        if(controller == null){
            controller = new Controller();
            logger.debug("Controller was successful created");
        }
        return controller;
    }
}

