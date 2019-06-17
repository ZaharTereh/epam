package by.training.epam.task4xml.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongRequest implements  Command {
    private static final Logger logger = LogManager.getLogger(WrongRequest.class.getName());
    @Override
    public String execute(String request) {
        logger.debug("Was writing unknown command");
        return "Wrong name of command \n You can use:\n1)read;\n2)change;\n3)view;\n4)exit;";
    }
}
