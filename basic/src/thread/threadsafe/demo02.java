package thread.threadsafe;

public class demo02 {
    public static void main(String[] args) {
        RunnableImpl02 runnable = new RunnableImpl02();
        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread0.start();
        thread1.start();
        thread3.start();
    }
}
