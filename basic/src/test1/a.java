package test1;

public class a {
    static{
        System.out.println("父类静态代码块");
    }

    public a() {
        System.out.println("父类无参构造方法");
    }

    X x = new X();

    {
        System.out.println("父类构造代码块");
    }

    public a(int num) {
        System.out.println("父类有参构造方法");
    }
}
