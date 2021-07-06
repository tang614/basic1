package thread.thread1;

/**
 * java程序属于抢占式调度，哪个线程的优先级高，哪个线程优先执行，同一个优先级则随机选择一个执行。
 * 在该实验中，三个线程的执行顺序是不确定的
 */
public class Demo01Thread {
    public static void main(String[] args) {
        //创建MyThread类的对象
        MyThread myThread = new MyThread();
        //给线程改名
        myThread.setName("线程1");
        myThread.start();

        MyThread01 thread01 = new MyThread01("线程2");
        thread01.start();

        //匿名方式创建线程对象
        //new MyThread().start();

        /*for (int i = 0; i < 10; i++) {
            System.out.println("main" + i);
        }*/

        //获取主线程的名称
        System.out.println(Thread.currentThread());
    }
}
