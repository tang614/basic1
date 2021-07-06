package designpattern.factory.simplefactory;

/**
 * 简单工厂模式：如果新增了产品，则需要修改getProduct()的内部逻辑，违反了开闭原则
 * 通过此工厂创建的实例所在的类有着共同的父类，因为静态方法的返回值需要统一
 */
public class SimpleFactory {
    public static Product getProduct(String type){
        if (type.equals("A")){
            return new ProductA();
        }
        if (type.equals("B")){
            return  new ProductB();
        }
        return null;
    }

    public static void main(String[] args) {
        Product a = SimpleFactory.getProduct("A");
        a.method();

        Product b = SimpleFactory.getProduct("B");
        b.method();
    }
}


