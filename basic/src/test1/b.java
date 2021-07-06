package test1;

public class b extends a {
    static {
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类构造代码块");
    }
    public b(){
        System.out.println("子类无参构造方法");
    }

    public b(int a){
        System.out.println("子类有参构造方法");
    }

    public static void main(String[] args) {
        b b1 = new b(1);
    }
}
