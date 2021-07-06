package designpattern.decorator;

/**
 * 装饰器模式
 */
public class RobotDecorator implements Robot{

    private Robot robot;

    public RobotDecorator(Robot robot){
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething(); //即使有了第二代机器人（RobotDecorator），但创建第二代机器人对象后也可能会只是用第一代机器人的功能
    }

    public void doMoreThing(){  //此方法，既有第一代机器人的功能，也有第二代机器人新添加的功能；
        robot.doSomething();
        System.out.println("洗碗、拖地！！！");
    }
}
