package ru.tutorial;


import ru.tutorial.MessageSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SenderApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageSender messageSender = context.getBean(MessageSender.class);

        Product best_product = Product.builder()
                .id(1010192)
                .name("best product")
                .price(100)
                .build();

        String msg = "java tutorial mgs";

        while (true){
            messageSender.sentMsg(best_product);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(best_product);
        }

    }
}
