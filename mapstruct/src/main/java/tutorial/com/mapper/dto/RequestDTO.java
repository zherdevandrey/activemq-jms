package tutorial.com.mapper.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDTO {

    private ClientDTO clientDTO;
    private CreditDTO creditDTO;
    List<RecordDTO> recordList;
    LocalDate localDate;
}
