package tutorial.com.concurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    static int count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0 ; i < 1000; i ++){
            executorService.execute(new MyTask());
        }
    }


    static class MyTask implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(count);
            count++;
        }
    }

}
