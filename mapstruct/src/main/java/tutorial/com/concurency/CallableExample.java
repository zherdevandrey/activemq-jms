package tutorial.com.concurency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask(myCallable);
        new Thread(futureTask).start();

        while (!futureTask.isDone()){
            System.out.println("calculation process");
        }

        Integer integer = futureTask.get();
        System.out.println("result is " + integer);
    }

    private static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0 ; i < 10; i++){
                sum = sum + i;
                Thread.sleep(100);
            }
            return sum;
        }
    }


}
