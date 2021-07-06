package thread.communication;

import thread.MyLock;

/**
 * 实现线程间通信：
 *      注意：notify()方法要在wait()方法之前
 *      // 刚进入同步代码块时获取锁，同步代码块执行完后释放锁
 *      // 执行sleep(秒数)，但是不会释放锁
 */
public class ThreadNumber2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (MyLock.o){
                System.out.println(2);
                MyLock.o.notify();
                try {
                    MyLock.o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
