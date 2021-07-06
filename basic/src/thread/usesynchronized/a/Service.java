package thread.usesynchronized.a;

/**
 * a包下锁对象为类Service对象:
 *      1、修饰同步代码块：synchronized后加this
 *      2、修饰方法：在方法返回值前加synchronized
 */
public class Service {

    //第一种
    /*public void m1(){
        synchronized (this) {
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
        synchronized(this){
            System.out.println("线程4Start--->" + System.currentTimeMillis());
            System.out.println("线程4End--->" + System.currentTimeMillis());
        }
    }*/

    //第二种
    public synchronized void m1(){
        System.out.println("线程3Start--->" + System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程3End--->" + System.currentTimeMillis());
    }

    public synchronized void m2(){
            System.out.println("线程4Start--->" + System.currentTimeMillis());
            System.out.println("线程4End--->" + System.currentTimeMillis());
    }

}
