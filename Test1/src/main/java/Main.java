

import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws Exception{
        //Calendar使用
        /*// 使用默认时区和语言环境获得一个日历
        Calendar cal = Calendar.getInstance();
        //cal.add(Calendar.YEAR,-1);
        System.out.println(cal.getTime());
        // 赋值时年月日时分秒常用的6个值，注意月份下标从0开始，所以取月份要+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));*/

        //BigDecimal使用
        /*BigDecimal bigDecimal = new BigDecimal("21.25456").setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(bigDecimal);*/



        //hashmap方法简用
        /*new HashMap<String, String>() {{
            put("BCode", "123");
            put("size", "123");
        }};*/

        //properties使用
        Properties pro=new Properties();
        pro.setProperty("driver", "com.mysql.jdbc.Driver");
        pro.setProperty("url", "jdbc:mysql///user");
        pro.setProperty("user", "root");
        pro.setProperty("password", "451535");
        //1.通过字节流的形式
        //store(OutputStream out, String comments)
        //outputStream:字节输出流   comments：配置文件说明
        //pro.store(new FileOutputStream(new File("C:/Users/Administrator/Documents/Tencent Files/466402070/FileRecv/app.ReflectTest.Test/jdbc1.properties")), "abc");

        //2.通过字符流的形式
        //store(Writer writer, String comments)
        //writer:字符输出流   comments：配置文件说明
        //pro.store(new FileWriter("src/jdbc6.properties"),  "数据库配置文件");






    }
}
