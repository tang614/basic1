package leedcode;

public class Sqrt {
    public static int MySqrt (int x) {
        // write code here
        int head = 0;
        int tail = x;
        long mid = (head + tail)/2;
        while(head <= tail){
            if(head == tail)
                return head;
            if((mid * mid)==x)
                return (int)mid;
            if((mid * mid)<x)
                head = (int)mid;
            mid = (head + tail)/2;
            if((mid * mid)>x)
                tail = (int)mid;
            mid = (head + tail)/2;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(MySqrt(45));
    }

}
