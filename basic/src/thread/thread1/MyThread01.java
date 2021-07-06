package thread.thread1;

public class MyThread01 extends Thread{
    public MyThread01(){}
    //给线程该名称的第二种方法
    public MyThread01(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}
