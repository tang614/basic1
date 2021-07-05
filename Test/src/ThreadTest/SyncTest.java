package ThreadTest;

public class SyncTest implements Runnable{

    // 共享变量
    static int i = 0;

    public static void increase(){
        i++;
    }

    public void increase1(){
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new SyncTest());
        Thread thread1 = new Thread(new SyncTest());
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(i);
    }
}
