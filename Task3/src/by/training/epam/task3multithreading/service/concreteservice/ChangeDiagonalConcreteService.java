package by.training.epam.task3multithreading.service.concreteservice;

import by.training.epam.task3multithreading.bean.Element;
import by.training.epam.task3multithreading.bean.Matrix;
import by.training.epam.task3multithreading.bean.MatrixThread;
import by.training.epam.task3multithreading.service.ChangeDiagonalService;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ChangeDiagonalConcreteService implements ChangeDiagonalService {
    @Override
    public String changeDiagonal() {
        ArrayList<ArrayList<Element>> commonResource = Matrix.getInstance().getMatrix();
        ReentrantLock locker = new ReentrantLock();
        try{
            for (int i = 1; i < 6; ++i) {
                Thread t = new MatrixThread(commonResource, locker, i);
                t.start();
            }
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException ex){
            ex.getMessage();
        }
        finally {
            return "Matrix diagonal was changed";
        }
    }
}
