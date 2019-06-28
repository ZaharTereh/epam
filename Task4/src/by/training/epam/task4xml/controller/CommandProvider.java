package by.training.epam.task4xml.controller;

import by.training.epam.task4xml.controller.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.SAX, new SAXCommand());
        commands.put(CommandName.STAX, new StAXCommand());
        commands.put(CommandName.DOM, new DOMCommand());
    }

    public Command getCommand(String name) {
        CommandName commandName = CommandName.valueOf(name);
        Command command = commands.get(commandName);
        return command;
    }
}