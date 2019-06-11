package by.training.epam.task3multithreading.service.concreteservice;

import by.training.epam.task3multithreading.bean.Matrix;
import by.training.epam.task3multithreading.service.ViewMatrixService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ViewMatrixOnConsoleService implements ViewMatrixService {
    private static final Logger logger = LogManager.getLogger(ViewMatrixOnConsoleService.class.getName());
    @Override
    public String getMatrixForView() {
        logger.debug("Matrix output");
        return Matrix.getInstance().toString();
    }
}
