package RetryTest;

public class Main {
    public static void main(String[] args) {
        int l = 0;
        retry:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 3)
                    //break ;
                    break retry;
                    //continue ;
                    //continue retry;
                l++;
                System.out.println(i + "---" + j);
            }
        }
        System.out.println(l);
    }
}
