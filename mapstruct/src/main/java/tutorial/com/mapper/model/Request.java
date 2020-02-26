package tutorial.com.mapper.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {

    private Client client;
    private Credit credit;
    List<Record> recordList;
    String date;

}
