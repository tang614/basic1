package thread.communication;

public class test {
    public static void main(String[] args) {
        new ThreadNumber2().start();
        new ThreadNumber1().start();
    }
}
