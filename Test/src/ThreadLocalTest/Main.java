package ThreadLocalTest;

public class Main {

    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("123");
                String s = local.get();
                System.out.println(s);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = local.get();
                System.out.println(s);
            }
        }).start();
    }
}
