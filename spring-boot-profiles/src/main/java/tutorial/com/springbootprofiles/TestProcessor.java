package tutorial.com.springbootprofiles;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class TestProcessor implements Processor{

    @Override
    public void process() {
        System.out.println("TestProcessor");

    }

}
