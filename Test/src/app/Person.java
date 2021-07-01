package app;

public class Person {
    private String name;
    private Integer age;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Person(Integer age) {
        this.age = age;
    }

    public Person(String tom, int i, String 上海){
    }

    public void abc(){
        System.out.println("abc");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
