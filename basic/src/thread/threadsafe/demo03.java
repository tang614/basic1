package thread.threadsafe;

public class demo03 {
    public static void main(String[] args) {
        RunnableImpl03 runnable = new RunnableImpl03();
        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread0.start();
        thread1.start();
        thread3.start();
    }
}
