package by.training.epam.task3multithreading.controller.command;

public class WrongRequest implements  Command {
    @Override
    public String execute(String request) {
        return "Wrong name of command \n You can use:\n1)read;\n2)change;\n3)view;\n4)exit;";
    }
}
