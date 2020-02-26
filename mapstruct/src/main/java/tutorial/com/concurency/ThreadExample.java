package tutorial.com.concurency;

public class ThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.run();
    }


    static class Task implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("calculated");
        }
    }

}
