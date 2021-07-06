package thread.test1;

public class Demo1 {
    private static Object object= new Object();
    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                synchronized (object){
                    Thread.currentThread().setName("线程一");
                    System.out.println(Thread.currentThread().getName() + "开始");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (object){
                    object.notify();
                    Thread.currentThread().setName("线程二");
                    System.out.println(Thread.currentThread().getName() + "开始");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
            }
        }.start();

        System.out.println(123123);
    }
}