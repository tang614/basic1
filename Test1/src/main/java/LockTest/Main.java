package LockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * https://blog.csdn.net/qq_39150049/article/details/112798911
 *
 * lock.lock()使用
 * 获得锁。如果锁不可用，则当前线程将被禁用以进行线程调度，并处于休眠状态，直到获取锁。
 */
public class Main {

    // 类成员变量
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Main main = new Main();
        new Thread(){
            public void run() {
                main.insert(Thread.currentThread());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                main.insert(Thread.currentThread());
            }
        }).start();
    }

    public void insert(Thread thread){
        // 如果锁为局部变量，则每一次调用insert方法是都会new一个锁，导致每个线程使用不同的锁
        // ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println(thread.getName() + "获取锁");
        }catch (Exception e){

        }finally {
            System.out.println(thread.getName() + "释放锁");
            lock.unlock();
        }
    }
}
