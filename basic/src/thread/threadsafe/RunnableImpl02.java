package thread.threadsafe;

/**
 * 对象锁是该类对象本身，即RunnableImpl实例对象
 */
public class RunnableImpl02 implements Runnable{
    private int tickets = 100;

    @Override
    public void run() {
        while (true){
            payTickets();
        }
    }

    public synchronized void payTickets(){
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

