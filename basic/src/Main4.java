public class Main4 {

    static {
        System.out.println("静态代码块，在编译的时候执行");
    }

    {
        System.out.println("构造代码块：创建类对象时执行");
    }

    public Main4(){
        System.out.println("无参");
    };

    public Main4(int a){
        System.out.println("有参");
    };

    public static void main(String[] args) {
        Main4 main4 = new Main4();
        Main4 main41 = new Main4(1);
    }

}
