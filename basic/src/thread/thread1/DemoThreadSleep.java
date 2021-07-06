package thread.thread1;

public class DemoThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        //模拟秒表
        for (int i = 0; i < 60; i++) {
            System.out.println(i);
            //让程序睡眠一秒钟
            Thread.sleep(1000);
        }
    }
}
