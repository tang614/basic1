package lambdaandstream;

public class Person {
    private Integer age;
    private Integer height;

    public Person() {
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person(Integer age, Integer height) {
        this.age = age;
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }
}
