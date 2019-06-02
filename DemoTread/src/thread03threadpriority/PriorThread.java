package thread03threadpriority;

import java.util.concurrent.TimeUnit;

public class PriorThread extends Thread{
    public PriorThread(String name) {
        super(name);
    }
    public void run() {
        for (int i = 0; i <50; i++) {
            System.out.println(getName() + " "+ i);
            try {
                TimeUnit.MILLISECONDS.sleep(0);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}


