package by.training.epam.task4xml.service.servicefactory;

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
