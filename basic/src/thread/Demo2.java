package thread;

public class Demo2 {
    private static volatile int t = 0;

    private static void increase() {
        t++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread [] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] =  new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 1000; i1++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(t);
    }
}
