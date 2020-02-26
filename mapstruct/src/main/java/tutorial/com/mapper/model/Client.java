package tutorial.com.mapper.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    String firstName;
    String secondName;
    LocalDate birthDate;

}
