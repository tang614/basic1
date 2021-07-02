package proxy;

public class StudentProxy implements Person{
    private Student student;

    public StudentProxy(Student student) {
        this.student = student;
    }

    @Override
    public void giveMoney() {
        student.giveMoney();
    }
}
