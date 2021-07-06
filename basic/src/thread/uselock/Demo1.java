package thread.uselock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock锁，锁住同步代码块；
 */
public class Demo1 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }

    }
}
