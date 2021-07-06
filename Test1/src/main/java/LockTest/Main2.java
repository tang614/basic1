package LockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock lock = new ReentrantLock(true) 表示线程开始运行的顺序 等于 线程获取锁的顺序
 */
public class Main2 {
     public static Lock lock = new ReentrantLock(true);

     public static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "运行");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获取锁");
            }catch (Exception e){}
            finally {
                lock.unlock();
            }
        }
    };
    public static void main(String[] args) {
        //Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(Main2.runnable);
            //threads[i] = thread;
            thread.start();
        }
        /*for (int j = 0; j < 10; j++) {
            threads[j].start();
        }*/
    }
}
