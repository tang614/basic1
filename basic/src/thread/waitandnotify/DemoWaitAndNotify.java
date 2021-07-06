package thread.waitandnotify;

public class DemoWaitAndNotify {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (o){
                        System.out.println("告诉老板要吃包子");
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("开始吃包子了...");
                        System.out.println("----------");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        //花6秒钟做包子
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o){
                        System.out.println("包子做好了，通知顾客");
                        o.notify();
                    }
                }
            }
        }.start();
    }
}
