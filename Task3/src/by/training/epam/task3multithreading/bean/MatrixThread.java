package by.training.epam.task3multithreading.bean;

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

    @Override
    public void run() {
        try {
            for(int i = 0; i < 9;i++){
                locker.lock();
                change(0 + (int) (Math.random() * 9));
                //change(i);
                locker.unlock();
                TimeUnit.MILLISECONDS.sleep(10);

            /*while (!Matrix.getInstance().isModified()){
                locker.lock();
                change(0 + (int) (Math.random() * 9));
                locker.unlock();
                TimeUnit.MILLISECONDS.sleep(10);*/

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    void change(int i){
        if(!commonResource.get(i).get(i).isModified()){
            commonResource.get(i).get(i).setInfo(idNumber);
            commonResource.get(i).get(i).setModified(true);
        }
    }
}
