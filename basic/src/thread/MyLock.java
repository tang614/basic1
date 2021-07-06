package thread;

public class MyLock {
    public static Object o = new Object();
    public static void main(String[] args){
        System.out.println(1);
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
