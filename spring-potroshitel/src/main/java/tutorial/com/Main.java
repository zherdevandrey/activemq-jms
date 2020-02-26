package tutorial.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Quoter bean = context.getBean(Quoter.class);
        bean.sayQuote();

        System.out.println("end");
    }

}
