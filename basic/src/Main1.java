import java.util.Scanner;
public class Main1
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

         long result1 = m;
        long result2 = n;

        for (int i = 0; i < n-1; i++) {
            m--;
            result1 = result1 * m;
        }
        for (int j = 0; j < n-1; j++) {
            n--;
            result2 = result2 * n;
        }

        long result = result1/result2;
        System.out.println(result);
    }
}
