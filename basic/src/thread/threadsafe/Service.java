package thread.threadsafe;

public class Service {

    Object obj = new Object();

    public void m1(){
        synchronized (obj) {
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
        synchronized(obj){
            System.out.println("线程4Start--->" + System.currentTimeMillis());
            System.out.println("线程4End--->" + System.currentTimeMillis());
        }
    }
}
