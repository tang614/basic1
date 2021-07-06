package thread.usesynchronized.c;

public class ThreadTest4 extends Thread{

    //方法一
    /*private Service service;

    public ThreadTest4(Service service){
        this.service = service;
    }

    public void run() {
        service.m2();
    }*/

    //方法二
    public void run(){
        Service.m2();
    }
}
