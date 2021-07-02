package app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {

        /*// 1. 创建线程池对象，设置核心线程和最大线程数为5
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // 2. 创建Runnable（任务）
        Runnable task =new Runnable(){
            public void run() {
                System.out.println(Thread.currentThread().getName() + "--->运行");
            }
        };
        // 3. 向线程池提交任务
        fixedThreadPool.execute(task);*/

        /*HashMap<String, Object> zhangsan = new HashMap<>();

        zhangsan.put("name", "张三");
        zhangsan.put("age", 18.4);
        zhangsan.put("birthday", "1900-20-03");
        zhangsan.put("majar", new String[] {"哈哈","嘿嘿"});
        zhangsan.put("null", null);
        zhangsan.put("house", false);
        System.out.println(zhangsan);
        JSONObject object = new JSONObject(zhangsan);
        System.out.println(new JSONObject(zhangsan));
        System.out.println(new JSONObject(zhangsan).toString());
        System.out.println("----------");*/

        /*JSONObject object = new JSONObject();
        object.put("13","13212");
        object.put("12","45456");
        HashMap<String, Object> map = new HashMap<>();
        map.put("a",object );*/




    }
}
