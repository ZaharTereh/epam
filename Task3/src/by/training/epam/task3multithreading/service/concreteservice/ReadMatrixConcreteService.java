package by.training.epam.task3multithreading.service.concreteservice;

import by.training.epam.task3multithreading.bean.Element;
import by.training.epam.task3multithreading.bean.Matrix;
import by.training.epam.task3multithreading.dao.daofactory.DAOFactory;
import by.training.epam.task3multithreading.service.ReadMatrixService;

import java.util.ArrayList;


public class ReadMatrixConcreteService implements ReadMatrixService {
    @Override
    public String readMatrix() {

        String matrixInString = DAOFactory.getInstance().getMatrixDAO().readMatrix();
        parse(matrixInString);
        return "Reading was successful";
    }

    void parse(String matrixInString){
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
        Matrix.getInstance().setMatrix(matrix);
    }

}
