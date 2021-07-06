package thread.usesynchronized.c;

public class ThreadTest3 extends Thread {

    //方法一
    /*private Service service;

    public ThreadTest3(Service service){
        this.service = service;
    }

    public void run() {
        service.m1();
    }*/

    //方法二
    @Override
    public void run(){
        Service.m1();
    }
}
