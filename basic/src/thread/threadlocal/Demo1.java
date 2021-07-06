package thread.threadlocal;

/**
 * 每一个线程有一个ThreadLocalMap类型的threadLocals的map集合，key-value为threadLocal和相应的值;
 * ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。
 */
public class Demo1 {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        protected Integer initialValue(){
            return 0;
        }
    };

    public static void main(String[] args) {
        new Thread(()->{
            threadLocal.set(12);
            threadLocal.set(45);
            System.out.println(threadLocal.get());
        }).start();

        new Thread(()->{
            threadLocal.set(44);
            System.out.println(threadLocal.get());
        }).start();

    }
}
