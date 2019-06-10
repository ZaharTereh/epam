package by.training.epam.task3multithreading.controller;

import by.training.epam.task3multithreading.controller.command.Command;

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
