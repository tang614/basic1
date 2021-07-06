package privatepublic;

import java.util.Objects;

public class Person implements Comparable<Person>{

    private int a;

    public Person(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Person{" +
                "a=" + a +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        //return this.a - o.getA();   //升序
        return o.getA() - this.a;     //倒序
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return a == person.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
