package reflection;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象,一个类只有一个Class对象
        Class c1 = Class.forName("reflection.User");
        System.out.println(c1);
        System.out.println(String.class);
    }
}

//实体类pojo,entity
class User{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
