package designpattern.factory.factory1;

public class iphoneFactory implements Factory{
    @Override
    public Phone createPhone() {
        return new iPhone();
    }
}
