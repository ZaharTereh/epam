package by.training.epam.task3multithreading.service.concreteservice;

import by.training.epam.task3multithreading.bean.Element;
import by.training.epam.task3multithreading.bean.Matrix;
import by.training.epam.task3multithreading.dao.DAOException;
import by.training.epam.task3multithreading.dao.daofactory.DAOFactory;
import by.training.epam.task3multithreading.service.ParseException;
import by.training.epam.task3multithreading.service.ReadMatrixService;
import by.training.epam.task3multithreading.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class ReadMatrixConcreteService implements ReadMatrixService {
    private static final Logger logger = LogManager.getLogger(ReadMatrixConcreteService.class.getName());
    @Override
    public boolean readMatrixISCorrectly() throws ServiceException{

        try {
            String matrixInString = DAOFactory.getInstance().getMatrixDAO().readMatrix();
            parse(matrixInString);
            logger.debug("Reading was successful");
            return true;
        }catch (DAOException ex){
            logger.error(ex.getMessage());
            throw new ServiceException();
        }catch (ParseException ex) {
            logger.error(ex.getMessage());
            throw new ServiceException();
        }
    }

    void parse(String matrixInString)throws ParseException{
        try {
            ArrayList<ArrayList<Element>> matrix = new ArrayList<>();
            String[][] matrixString;
            String[] lines = matrixInString.split("\n");
            matrixString = new String[lines.length][];
            int i = 0;
            for (String line : lines) {
                String[] elements = line.split(" ");
                matrixString[i] = elements;
                i++;
            }

            for (String[] line : matrixString) {
                ArrayList<Element> linesList = new ArrayList<>();
                for (String element : line) {
                    linesList.add(new Element(Integer.valueOf(element)));
                }
                matrix.add(linesList);
            }
            Matrix.getInstance().setSize(matrix.size());
            Matrix.getInstance().setMatrix(matrix);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new ParseException();
        }

    }

}
