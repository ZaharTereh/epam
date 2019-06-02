package thread01helloworld;

public class MyTread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        MyTread thread = new MyTread();
        thread.start();
    }
}
