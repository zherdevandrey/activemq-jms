package tutorial.com.mapper.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecordDTO {

    private String history;
    private int delay;

}
