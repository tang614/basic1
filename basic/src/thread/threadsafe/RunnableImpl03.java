package thread.threadsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对象锁是该类对象本身，即RunnableImpl实例对象
 */
public class RunnableImpl03 implements Runnable{
    private int tickets = 100;

    Lock l = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            l.lock();
            if (tickets > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + tickets + "张票");
                    tickets--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            l.unlock();
        }
    }
}

