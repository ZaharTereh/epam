package thread09producerconsumer;

public class Consumer extends Thread  {
    Store store; // объект склада, с которого покупатель будет брать товар
    int product = 0; // текущее количество товаров со склада

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (product < 5) {// пока количество товаров не будет равно 5

                product = product + store.get(); // берем по одному товару со склада
                System.out.println("Потребитель купил " + product + " товар(ов)");
                sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("поток потребителя прерван");
        }
    }

}
