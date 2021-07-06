package thread.uselock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                boolean b = false; //多个线程共享一个变量？？？？？？？？？？？？？？？？？？？
                try {
                    //b = lock.tryLock(); 尝试加锁，如果失败直接放弃
                    b = lock.tryLock(1500, TimeUnit.MILLISECONDS); //尝试加锁，如果失败等待1500ms(堵塞在这1500ms),之后还拿不到锁就放弃；
                    if (b)
                        System.out.println("hello");
                        Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (b)
                        lock.unlock();
                }
            }).start();
        }
    }
}
