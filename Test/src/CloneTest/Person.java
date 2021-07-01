package CloneTest;

import java.io.Serializable;

public class Person implements Cloneable, Serializable {
    private String name;
    private Integer age;
    private Address address;

    protected void test(){
        System.out.println("test");
    }

    public Person(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person clone = (Person)super.clone();
        //Address clone1 = (Address)clone.getAddress().clone();
        clone.address = (Address) address.clone();
        return clone;
    }
}
