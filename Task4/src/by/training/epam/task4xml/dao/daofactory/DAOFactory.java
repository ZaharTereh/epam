package by.training.epam.task4xml.dao.daofactory;


public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    //private final MatrixDAO fileMatrixDAO = new FileMatrixDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){   return instance;  }

    //public MatrixDAO getMatrixDAO(){   return fileMatrixDAO;  }
}
