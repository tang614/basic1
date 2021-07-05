package ThreadTest;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws Exception{

        //模拟多线程并发执行，如：多个线程在指定时刻进行抢购（秒杀）
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    //准备完毕……运动员都阻塞在这，等待号令
                    countDownLatch.await();
                    String parter = "【" + Thread.currentThread().getName() + "】";
                    System.out.println(parter + "开始执行……");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("---开始跑步---");
        countDownLatch.countDown();// 发令枪：执行发令

        //模拟线程之间执行具有先后顺序,如：多个线程进行信息采集，主线程进行信息合并
        CountDownLatch downLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "已进行数据采集");
                downLatch.countDown();
            }).start();
        }
        downLatch.await();
        System.out.println(Thread.currentThread().getName() + "主线程进行数据合并");
    }
}
