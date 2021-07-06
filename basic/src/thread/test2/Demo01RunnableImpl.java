package thread.test2;

/**
 * 第二种创建线程的方法
 */
public class Demo01RunnableImpl {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread thread = new Thread(runnable);
        thread.setName("线程一");
        Thread thread0 = new Thread(runnable);
        thread0.setName("线程零");
        //Thread thread1 = new Thread(new RunnableImpl());//匿名创建实现类对象
        //System.out.println(thread == thread0); //false

        thread.start();     // 两个线程同时调用同一个对象的方法，会出现线程安全问题
        thread0.start();
    }
}
