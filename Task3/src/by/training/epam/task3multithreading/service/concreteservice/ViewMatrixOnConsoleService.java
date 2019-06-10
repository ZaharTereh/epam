package by.training.epam.task3multithreading.service.concreteservice;

import by.training.epam.task3multithreading.bean.Matrix;
import by.training.epam.task3multithreading.service.ViewMatrixService;

public class ViewMatrixOnConsoleService implements ViewMatrixService {
    @Override
    public String getMatrixForView() {
        return Matrix.getInstance().toString();
    }
}
