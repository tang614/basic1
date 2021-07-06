package thread.usesynchronized.c;

/**
 * c包下锁对象为类的class对象（即Service.class）
 *      1、修饰同步代码块：synchronized后加Service.class；
 *      2、修饰静态方法：在static后，返回值类型前加synchronized
 */
public class Service {

    //方法一
    /*public void m1(){
        synchronized (Service.class) {
            System.out.println("线程3Start--->" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3End--->" + System.currentTimeMillis());
        }
    }

    public void m2(){
        synchronized(Service.class){
            System.out.println("线程4Start--->" + System.currentTimeMillis());
            System.out.println("线程4End--->" + System.currentTimeMillis());
        }
    }*/

    //方法二
    public static synchronized void m1(){
            System.out.println("线程3Start--->" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3End--->" + System.currentTimeMillis());
    }

    public static synchronized void m2(){
            System.out.println("线程4Start--->" + System.currentTimeMillis());
            System.out.println("线程4End--->" + System.currentTimeMillis());
    }
}
