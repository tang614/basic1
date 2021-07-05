package LockTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.tryLock()使用
 * 只有在调用时才可以获得锁。如果可用，则获取锁定，并立即返回值为true；如果锁不可用，则此方法将立即返回值为false
 */
public class Main1 {
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Main1 main1 = new Main1();

        new Thread(){
            public void run(){
                main1.insert(Thread.currentThread());
            }
        }.start();

        new Thread(){
            public void run(){
                main1.insert(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread){
        if (lock.tryLock()){
            try {
                System.out.println(thread.getName() + "获取锁");
                Thread.sleep(1000);
            }catch (Exception e){

            }finally {
                lock.unlock();
                System.out.println(thread.getName() + "释放锁");
            }
        }else
            System.out.println(thread.getName() + "获取锁失败");
    }
}
