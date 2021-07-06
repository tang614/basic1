package thread.usesynchronized.a;

public class ThreadTest3Demo {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadTest3 threadTest3 = new ThreadTest3(service);
        ThreadTest4 threadTest4 = new ThreadTest4(service);
        threadTest3.start();
        threadTest4.start();
    }
}
