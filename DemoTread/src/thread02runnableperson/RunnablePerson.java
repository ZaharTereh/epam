package thread02runnableperson;

public class RunnablePerson extends  Person implements Runnable {
    public RunnablePerson(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            System.out.println(getName() + " Hello world");
        }
        Thread thread = Thread.currentThread();
        System.out.println(thread);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");
        RunnablePerson p1 = new RunnablePerson("Alisa");
        Thread thread1 = new Thread(p1);
        thread1.setName("Alisa");
        thread1.start();

        RunnablePerson p2 = new RunnablePerson("Bob");
        Thread thread2 = new Thread(p2);
        thread2.start();
        thread2.setName("Bob");

        thread1.join();

        Thread thread = Thread.currentThread();
        System.out.println(thread);
        System.out.println("Main stop");
    }
}
