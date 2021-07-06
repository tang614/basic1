package thread;

/**
 * 使用了创建线程的两种简便方法，
 * 第二种通过匿名Thread子类的方式创建竟然直接在（）->{}大括号里写线程执行的内容（相当于重写run()）,我惊了！！！
 */
public class Demo1 {
    public static void main(String[] args) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用了匿名内部类，即省略了接口实现类的创建，同时也使用了匿名对象");
                System.out.println(Thread.currentThread().getName());
            }
        }).start();*/

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                //synchronized (thread.Demo1.class) {
                    System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
                //}
            }).start();
        }
    }
}
