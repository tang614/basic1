package designpattern.decorator;

public class FirstRobot implements Robot{
    @Override
    public void doSomething() {
        System.out.println("唱歌、跳舞！！！");
    }
}
