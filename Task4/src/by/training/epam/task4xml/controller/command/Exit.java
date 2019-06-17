package by.training.epam.task4xml.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Exit implements Command{
    private static final Logger logger = LogManager.getLogger(Exit.class.getName());

    @Override
    public String execute(String request) {
        logger.debug("Exit from application");
        return "Exit";
    }
}
