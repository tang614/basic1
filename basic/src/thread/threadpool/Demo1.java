package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程池的四种方法
 * 线程池的作用：
 *      第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
 *      第二：提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
 *      第三：提高线程的可管理性。
 */
public class Demo1 {
    public static void main(String[] args) {

        //创建线程池，线程数量为5个
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //关闭连接
        service.shutdown();
    }

}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
