package ThreadLocalTest;

// 多个线程使用ThreadLocal类型的共享变量，解析见笔记...
public class Main {
    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("1243");
                local.remove();
                System.out.println(local.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(local.get());
            }
        }).start();
    }
}
