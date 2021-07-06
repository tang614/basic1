package thread.test2;

public class RunnableImpl implements Runnable{

    private int id = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            /*synchronized (this){

                if(id > 0){
                    System.out.println(Thread.currentThread().getName() + "start");
                    System.out.println(Thread.currentThread().getName() + "id是" + id + "   i是" + i);
                    id--;
                }
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "end  i是" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }*/

            //如果不使用synchronized,id会出现并发问题，i不会，i是局部变量
            if (id > 0){
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "id是" + id + "   i是" + i);
                id--;
                System.out.println(Thread.currentThread().getName() + "end");
            }
        }
    }

}
