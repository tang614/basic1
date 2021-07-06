package LockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.lockInterruptibly()
 * 获取锁，如果可用并立即返回。如果锁不可用，那么当前线程将被禁用以进行线程调度，并且处于休眠状态，和lock()方法不同的是在锁的获取中可以中断当前线程（相应中断。
 */
public class Main3 {
    // 类成员变量
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Main3 main3 = new Main3();
        Thread thread1 = new Thread(){
            public void run() {
                try {
                    main3.insert(Thread.currentThread());

                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread() + "线程中断");
                }
            }
        };

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    main3.insert(Thread.currentThread());
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "线程中断");
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + "获取锁");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch (Exception e){

        }finally {
            System.out.println(thread.getName() + "释放锁");
            lock.unlock();
        }
    }
}
