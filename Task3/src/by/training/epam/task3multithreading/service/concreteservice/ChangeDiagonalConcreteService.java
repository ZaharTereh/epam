package by.training.epam.task3multithreading.service.concreteservice;

import by.training.epam.task3multithreading.bean.Element;
import by.training.epam.task3multithreading.bean.Matrix;
import by.training.epam.task3multithreading.bean.MatrixThread;
import by.training.epam.task3multithreading.service.ChangeDiagonalService;
import by.training.epam.task3multithreading.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ChangeDiagonalConcreteService implements ChangeDiagonalService {
    private static final Logger logger = LogManager.getLogger(ChangeDiagonalConcreteService.class.getName());
    @Override
    public boolean changeDiagonal() throws ServiceException {
        ArrayList<ArrayList<Element>> commonResource = Matrix.getInstance().getMatrix();
        if(commonResource == null){throw  new ServiceException();}

        ReentrantLock locker = new ReentrantLock();
        try{
            for (int i = 1; i < 6; ++i) {
                Thread t = new MatrixThread(commonResource, locker, i);
                t.start();
            }
            TimeUnit.SECONDS.sleep(1);
            logger.debug("Diagonal was changed");
        }catch (InterruptedException ex){
            logger.error(ex.getMessage());
            throw new ServiceException();
        }
        return true;
    }
}
