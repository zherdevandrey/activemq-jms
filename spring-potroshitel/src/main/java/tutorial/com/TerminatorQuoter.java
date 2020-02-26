package tutorial.com;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {

    private String message;

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    @PostConstruct
    public void init(){
        System.out.println("phase 2");
        System.out.println("repeat " + repeat);
    }

    public TerminatorQuoter() {
        System.out.println("phase 1");
        System.out.println("repeat " + repeat);
    }

    public void sayQuote() {

        for (int i = 0 ; i < repeat; i++) {
            System.out.println("message " + message);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
