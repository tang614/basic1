package LockTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Thread.sleep() 使当前线程休眠，如果线程持有锁则不会释放锁
 * Object.wait()、notify()、notifyAll() 是当前线程休眠，如果持有锁则释放锁，唤醒线程则用同一个object的notify()
 * synchronized处使用的Object 和 Object.wait()是同一个，所以一般使用容器对象，此例中指list
 */
public class Main5 {
    // 队列
    public static List<Integer> list = new ArrayList<>();
    // 队列最大值
    public static Integer size = 10;

    public static void main(String[] args) {
        Object o = new Object();
        Thread producer = new Thread("producer"){
            public void run() {
                while (true) {
                    synchronized (Main5.list) {
                        Main5.work(Thread.currentThread(), Main5.list);
                    }
                }
            }
        };

        Thread customer = new Thread("customer"){
            public void run() {
                while (true) {
                    synchronized (Main5.list) {
                        Main5.work(Thread.currentThread(), Main5.list);
                    }
                }

            }
        };

        producer.start();
        customer.start();
    }

    public static void work(Thread thread,List list){
        String name = thread.getName();
        if ("customer".equals(name)){
            if (list.size() > 0){
                System.out.println("当前队列数量：" + list.size() + "  ,消费者消费了" + list.remove(0));
                list.notify();
            }else {
                try {
                    System.out.println("队列空了，消费者线程停止并释放锁");
                    list.notify();
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if ("producer".equals(name)){
            if (list.size() < Main5.size){
                System.out.println("当前队列数量：" + list.size() + "生产者生产" + list.add(1));
                list.notify();
            }else {
                try {
                    System.out.println("队列满了，生产者线程停止并释放锁");
                    list.notify();
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
