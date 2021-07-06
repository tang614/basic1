package thread.usesynchronized.c;

public class ThreadTest3Demo {
    public static void main(String[] args) {

        //方法一
        /*Service service = new Service();
        ThreadTest3 threadTest3 = new ThreadTest3(service);
        ThreadTest4 threadTest4 = new ThreadTest4(service);
        threadTest3.start();
        threadTest4.start();*/

        //方法二
        ThreadTest3 threadTest3 = new ThreadTest3();
        ThreadTest4 threadTest4 = new ThreadTest4();
        threadTest3.start();
        threadTest4.start();
    }
}
