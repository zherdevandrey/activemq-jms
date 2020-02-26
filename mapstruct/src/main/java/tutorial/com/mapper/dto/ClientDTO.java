package tutorial.com.mapper.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {

    String fullName;
    LocalDate birthDate;

}
