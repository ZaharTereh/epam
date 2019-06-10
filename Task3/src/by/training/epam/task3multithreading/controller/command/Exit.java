package by.training.epam.task3multithreading.controller.command;

public class Exit implements Command{
    @Override
    public String execute(String request) {
        return "Exit";
    }
}
