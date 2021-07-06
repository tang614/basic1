package designpattern.factory.factory1;

public class

HuaWeiFactory implements Factory{
    @Override
    public Phone createPhone() {
        return new HuaWeiPhone();
    }
}
