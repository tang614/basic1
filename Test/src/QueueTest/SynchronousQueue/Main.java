package QueueTest.SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

/**
 * https://blog.csdn.net/yanyan19880509/article/details/52562039
 *
 * 同步队列
 * SynchronousQueue是一个队列，但它的特别之处在于它内部没有容器，一个生产线程，当它生产产品（即put的时候），如果当前没有人想要消费产品(即当前没有线程执行take)，此生产线程必须阻塞，等待一个消费线程调用take操作，take操作将会唤醒该生产线程，同时消费线程会获取生产线程的产品（即数据传递），这样的一个过程称为一次配对过程(当然也可以先take后put,原理是一样的)。
 */
public class Main {
    public static void main(String[] args) {

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("生产者线程开始");
                try {
                    synchronousQueue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产者线程结束");
            }
        });

        Thread customerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("消费者线程开始");
                try {
                    System.out.println("从队列消费一个产品");
                    synchronousQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者线程结束");
            }
        });

        producerThread.start();
        customerThread.start();
    }
}
