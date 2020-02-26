package tutorial.com.mapper.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Record {

    private String history;
    private int delay;

}
