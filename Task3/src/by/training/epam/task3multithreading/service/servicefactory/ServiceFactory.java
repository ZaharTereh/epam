package by.training.epam.task3multithreading.service.servicefactory;

import by.training.epam.task3multithreading.service.ChangeDiagonalService;
import by.training.epam.task3multithreading.service.ReadMatrixService;
import by.training.epam.task3multithreading.service.ViewMatrixService;
import by.training.epam.task3multithreading.service.concreteservice.ChangeDiagonalConcreteService;
import by.training.epam.task3multithreading.service.concreteservice.ReadMatrixConcreteService;
import by.training.epam.task3multithreading.service.concreteservice.ViewMatrixOnConsoleService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ReadMatrixService readMatrixService = new ReadMatrixConcreteService();
    private final ChangeDiagonalService diagonalService = new ChangeDiagonalConcreteService();
    private final ViewMatrixService viewMatrixService = new ViewMatrixOnConsoleService();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){   return instance;  }
    public ReadMatrixService getReadMatrixService(){   return readMatrixService;  }
    public ChangeDiagonalService getDiagonalService(){
        return diagonalService;
    }
    public ViewMatrixService getViewMatrixService(){
        return viewMatrixService;
    }
}
