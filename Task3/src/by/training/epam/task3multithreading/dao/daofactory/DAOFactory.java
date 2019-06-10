package by.training.epam.task3multithreading.dao.daofactory;

import by.training.epam.task3multithreading.dao.MatrixDAO;
import by.training.epam.task3multithreading.dao.concretedao.FileMatrixDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final MatrixDAO fileMatrixDAO = new FileMatrixDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){   return instance;  }

    public MatrixDAO getMatrixDAO(){   return fileMatrixDAO;  }
}
