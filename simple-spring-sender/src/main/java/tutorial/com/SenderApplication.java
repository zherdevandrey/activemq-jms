package tutorial.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutorial.com.config.AppConfig;
import tutorial.com.model.Product;
import tutorial.com.sender.MessageSender;

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
        messageSender.sentMsg(best_product);
        System.out.println(best_product);
    }
}
