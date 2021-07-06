package designpattern.factory.factory1;

public class Test {
    public static void main(String[] args) {
        //创建华为手机工厂
        Factory huaWeiFactory = new HuaWeiFactory();
        //华为手机工厂创建手机
        Phone phone = huaWeiFactory.createPhone();
        phone.method();
    }
}
