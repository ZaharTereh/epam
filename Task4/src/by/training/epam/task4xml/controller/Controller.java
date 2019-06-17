package by.training.epam.task4xml.controller;

import by.training.epam.task4xml.controller.command.Command;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request){

    Command executionCommand;
    executionCommand = provider.getCommand(request);

    String response;
    response = executionCommand.execute(request);

    return response;
    }

}
