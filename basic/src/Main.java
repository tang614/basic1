import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            String s = sc.next();
            String[] strings = s.split("->");
            map.put(strings[0], strings[1]);
        }

        System.out.println(parse(temp,count,map));
    }

    public static String parse(String template,int count, Map<String, String> dict){
        String[] strings = template.split("");
        int length = strings.length;
        int left = 0, right = 0;
        for (int i = 0; i < length-1; i++) {
            if (strings[i].equals("{") && strings[i+1].equals("{"))
                left = i+1;
            if (strings[i].equals("}") && strings[i+1].equals("}")){
                right = i;
                break;
            }
        }
        if (right == left + 1){
            return template;
        }

        String substring = template.substring(left + 1, right - 1);


        if (dict.containsKey(substring)){
            String result="";
            String append = dict.get(substring);
            for (int i = 0; i < left-1; i++) {
                result += strings[i];
            }
            result += append;

            for (int i = right+2; i < length; i++) {
                result += strings[i];
            }

            return result;
        }
        String result="";
        for (int i = 0; i < left-1; i++) {
            result += strings[i];
        }
        for (int i = right+2; i < length; i++) {
            result += strings[i];
        }

        return result;

    }
}
