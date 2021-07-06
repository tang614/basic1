package thread.threadsafe;

public class RunnableImpl01 implements Runnable{
    private int tickets = 100;
    //对象锁，
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if(tickets > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + tickets + "张票");
                    tickets--;
                }
            }
        }
    }
}

