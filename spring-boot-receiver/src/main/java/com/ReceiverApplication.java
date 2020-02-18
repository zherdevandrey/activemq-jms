package tutorial.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutorial.com.config.AppConfig;

import javax.jms.JMSException;

public class ReceiverApplication {

    public static void main(String[] args) throws JMSException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        while (true){
            try
            {
                Thread.sleep(6000000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }



    }


}
