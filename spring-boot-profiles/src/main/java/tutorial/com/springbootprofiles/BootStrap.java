package tutorial.com.springbootprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    @Autowired
    Processor processor;

//    @Value("${some.prop}")
//    String testProp;
//
//    @Value("${some.prop}")
//    String prodProp;

    @Override
    public void run(String... args) throws Exception {
        processor.process();
    }
}
