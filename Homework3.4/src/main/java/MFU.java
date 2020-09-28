

public class MFU {

    Object printLock = new Object();
    Object scanLock = new Object();


    public static void main(String[] args) {

        final MFU mfu = new MFU();

        new Thread(()-> mfu.print()).start();
        new Thread(()-> mfu.print()).start();
        new Thread(()-> mfu.scan(false)).start();

    }

    public void print() {
        synchronized (printLock) {
            System.out.println("Printing...");
            for (int i = 0; i < 10; i++) {
                System.out.print(". ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("End of print!");
        }

    }

    public void scan(boolean internet) {
        synchronized (scanLock) {
            if (!internet) {
                synchronized (printLock) {
                    System.out.println("Scanning...");
                    for (int i = 0; i < 10; i++) {
                        System.out.print(". ");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println();
                    System.out.println("End of Scan! \nWait for printing to start...");
                    System.out.println("Printing...");
                    for (int i = 0; i < 10; i++) {
                        System.out.print(". ");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println();
                    System.out.println("End of print!");
                }
            } else {
                System.out.println("Scanning...");
                for (int i = 0; i < 10; i++) {
                    System.out.print(". ");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
                System.out.println("End of Scan! \nFile was success send!");
            }
        }
    }
}
