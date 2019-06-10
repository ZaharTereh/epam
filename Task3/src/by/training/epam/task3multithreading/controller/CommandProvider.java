package by.training.epam.task3multithreading.controller;

import by.training.epam.task3multithreading.controller.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.READ, new ReadFromFile());
        repository.put(CommandName.VIEW, new ViewMatrix());
        repository.put(CommandName.CHANGE, new ChangeDiagonal());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.EXIT, new Exit());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {

            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}