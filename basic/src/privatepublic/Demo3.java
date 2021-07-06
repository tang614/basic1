package privatepublic;

//局部内部类
public class Demo3 {

    public void method(){
        int b = 10;
        class Inner{
            int a = 20;
            public void me(){
                int a = 30;
                System.out.println(a);
                System.out.println(this.a);
            }
        }
        Inner inner = new Inner();
        inner.me();
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        demo3.method();
    }
}
