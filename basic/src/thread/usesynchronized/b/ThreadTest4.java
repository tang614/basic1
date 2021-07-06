package thread.usesynchronized.b;

public class ThreadTest4 extends Thread{

    private Service service;

    public ThreadTest4(Service service){
        this.service = service;
    }

    public void run() {
        service.m2();
    }
}
