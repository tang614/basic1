package thread.usesynchronized.a;

/**
 * ThreadTest3、ThreadTest4、Service、ThreadTest3Demo是一组实验，
 * 为了验证：
 */
public class ThreadTest3 extends Thread {

    private Service service;

    public ThreadTest3(Service service){
        this.service = service;
    }

    public void run() {
        service.m1();
    }
}
