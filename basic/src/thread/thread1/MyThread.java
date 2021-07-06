package thread.thread1;

public class MyThread extends Thread{
    @Override
    public void run() {
        /*for (int i = 0; i < 10; i++) {
            System.out.println("MyThread" + i);
        }*/

        //获取线程名称
        //String name = this.getName();
        //System.out.println(name);

        Thread thread = Thread.currentThread();
        System.out.println(thread);//Thread[Thread-0,5,main] 分别表示[线程名称, 线程优先级, 线程所属线程组]

    }
}
