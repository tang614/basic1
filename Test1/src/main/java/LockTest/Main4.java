package LockTest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 两个线程共享读锁
 *
 * tips:
 * 如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。
 * 如果有一个线程已经占用了写锁，则此时其他线程如果申请写锁或者读锁，则申请的线程会一直等待释放写锁。
 */
public class Main4 {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static Integer a = 1;

    public static void main(String[] args) {
        Main4 main4 = new Main4();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                main4.insert(Thread.currentThread());
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                main4.insert(Thread.currentThread());
            }
        };

        thread1.start();
        thread2.start();
    }

    public void insert(Thread thread){
        readWriteLock.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 0.000001){
                System.out.println(thread.getName() + "正在进行读操作");
            }
        }catch (Exception e){

        }finally {
            System.out.println(thread.getName() + "释放读锁");
            readWriteLock.readLock().unlock();
        }
    }
}
