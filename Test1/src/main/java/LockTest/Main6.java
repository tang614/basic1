package LockTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁： lock = object监视器
 * 上锁操作：lock.lock() = synchronized (object)
 * 线程休眠与唤醒： object.wait() = condition.await()、object.notify() = condition.signal()
 * tips:
 *      syn中只有一个object，所有的线程都必须等待同一个且唯一个object唤醒，但lock中一个lock可以有多个condition，线程必须等待同一个condition唤醒；
 *      lock.lock();
 *          condition.await()
 *      lock.unlock();
 *      condition的操作必须在lock中，执行await()后释放锁，被唤醒后线程自动获取锁
 */
public class Main6 {
    // 队列
    public static List<Integer> list = new ArrayList<>();
    // 队列最大值
    public static Integer size = 10;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread producer = new Thread("producer"){
            public void run() {
                while (true) {
                    lock.lock();
                    try{
                        Main6.work(Thread.currentThread(),Main6.list,condition);
                    }catch (Exception e){}
                    finally {
                        lock.unlock();
                    }
                }
            }
        };

        Thread customer = new Thread("customer"){
            public void run() {
                while (true) {
                    lock.lock();
                    try{
                        Main6.work(Thread.currentThread(),Main6.list,condition);
                    }catch (Exception e){}
                    finally {
                        lock.unlock();
                    }
                }
            }
        };

        producer.start();
        customer.start();
    }

    public static void work(Thread thread,List list,Condition condition){
        String name = thread.getName();
        if ("customer".equals(name)){
            if (list.size() > 0){
                System.out.println("当前队列数量：" + list.size() + "  ,消费者消费了" + list.remove(0));
                condition.signal();
            }else {
                try {
                    System.out.println("队列空了，消费者线程停止并释放锁");
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if ("producer".equals(name)){
            if (list.size() < Main5.size){
                System.out.println("当前队列数量：" + list.size() + "生产者生产" + list.add(1));
                condition.signal();
            }else {
                try {
                    System.out.println("队列满了，生产者线程停止并释放锁");
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
