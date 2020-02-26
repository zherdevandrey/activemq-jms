package tutorial.com.springbootprofiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdProcessor implements Processor{
    @Override
    public void process() {
        System.out.println("ProdProcessor");
    }
}
