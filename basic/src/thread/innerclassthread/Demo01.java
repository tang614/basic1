package thread.innerclassthread;

/**
 * 使用匿名内部类的方法创建线程
 */
public class Demo01 {
    public static void main(String[] args) {
        //第一种方法
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        //第二种方法
        //Runnable r = new RunnableImpl(); 多态
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread thread = new Thread(r);
        thread.start();
    }
}
