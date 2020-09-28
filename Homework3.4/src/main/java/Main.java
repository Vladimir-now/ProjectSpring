public class Main {


    /**
     * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
     *      Используйте wait/notify/notifyAll.
     * 2. Создать модель MFU (c возможность сканирования, печати и ксерокопии).
      */

    static volatile char symbol;

    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                symbol = 'A';
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        lock.notifyAll();
                        System.out.print(symbol);
                        symbol = 'B';
                        while (symbol != 'A') {
                            if (i == 4) break;
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        lock.notifyAll();
                        symbol = 'B';
                        System.out.print(symbol);
                        symbol = 'C';
                        while (symbol != 'B') {
                            if (i == 4) break;
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run () {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        lock.notifyAll();
                        symbol = 'C';
                        System.out.print(symbol);
                        symbol = 'A';
                        while (symbol != 'C') {
                            if (i == 4) break;
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }
}


