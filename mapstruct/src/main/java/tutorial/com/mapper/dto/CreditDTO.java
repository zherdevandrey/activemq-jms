package tutorial.com.mapper.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditDTO {

    LocalDate date;
    BigDecimal amount;
    String secretKey;

}
