package createObject;

public class Person {
    private String name;
    private Integer age;
    public Person() {
        System.out.println("无参构造");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造");
    }
}
