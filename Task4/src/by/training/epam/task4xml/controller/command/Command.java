package by.training.epam.task4xml.controller.command;

import java.util.List;

public interface Command {
    List<List<String>> execute(String request);
}
