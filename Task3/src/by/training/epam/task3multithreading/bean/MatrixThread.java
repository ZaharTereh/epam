package by.training.epam.task3multithreading.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixThread extends Thread {
    private ReentrantLock locker;
    private ArrayList<ArrayList<Element>> commonResource;
    private int idNumber;

    public MatrixThread(ArrayList<ArrayList<Element>> commonResource, ReentrantLock locker,int idNumber){
        this.locker = locker;
        this.commonResource = commonResource;
        this.idNumber = idNumber;
        this.setName("Поток " + Integer.toString(idNumber));
    }
    private static final Logger logger = LogManager.getLogger(MatrixThread.class.getName());

    @Override
    public void run() throws NullPointerException{
        int size = Matrix.getInstance().getSize();
        try {
            for(int i = 0; i < size;i++){
                locker.lock();
                //change(0 + (int) (Math.random() * size));
                change(i);
                locker.unlock();
                TimeUnit.MILLISECONDS.sleep(10);

            /*while (!Matrix.getInstance().isModified()){
                locker.lock();
                change(0 + (int) (Math.random() * size));
                locker.unlock();
                TimeUnit.MILLISECONDS.sleep(10);*/

            }
        } catch (InterruptedException ex) {
            logger.error(ex.getMessage());
        }
    }

    void change(int i) throws NullPointerException{
        if(!commonResource.get(i).get(i).isModified()){
            commonResource.get(i).get(i).setInfo(idNumber);
            commonResource.get(i).get(i).setModified(true);
        }
    }
}
