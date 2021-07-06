package designpattern.decorator;

public class Test {
    public static void main(String[] args) {
        new RobotDecorator(new FirstRobot()).doSomething();
        System.out.println("=====");
        new RobotDecorator(new FirstRobot()).doMoreThing();
    }
}