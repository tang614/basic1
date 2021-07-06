package designpattern.singleton;

/**
 * 单例模式
 */
public class Singleton {
    //饿汉式：在类加载的时候立马进行实例化
    /*private static Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return singleton;
    }*/

    //懒汉式：在第一次使用getInstance()的时候进行实例化
    /*private static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }*/

    //懒汉式：在方法前加锁，防止多个线程同时访问getInstance(),以达到线程同步；
    /*private static Singleton singleton;

    private Singleton(){}

    public synchronized static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }*/

    //懒汉式的双重锁机制，减少同步的范围
    /*private volatile static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/

}
