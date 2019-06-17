package by.training.epam.task4xml.view;

import by.training.epam.task4xml.controller.Controller;
import by.training.epam.task4xml.controller.controllerfactory.ControllerFactory;

import java.util.Scanner;

public class Console {
    private static Controller controller = ControllerFactory.getInstance().getController();

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        String request;
        String response;
        System.out.print("You can use commands:\n1)read;\n2)change;\n3)view;\n4)exit;\n");
        do{
            System.out.print("Enter command:");
            response = scanner.nextLine();
            request = controller.executeTask(response);
            System.out.println(request);
        }while (!"exit".equalsIgnoreCase(response));
    }

    private Console(){}
}
