package tutorial.com.mapper.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credit {

    LocalDate date;
    BigDecimal amount;

}
