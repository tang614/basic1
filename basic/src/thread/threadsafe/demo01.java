package thread.threadsafe;

public class demo01 {
    public static void main(String[] args) {
        RunnableImpl01 runnable = new RunnableImpl01();
        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread0.start();
        thread1.start();
        thread3.start();
    }
}
