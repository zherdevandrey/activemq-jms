package tutorial.com;


import org.mapstruct.factory.Mappers;
import tutorial.com.mapper.ModelMapper;
import tutorial.com.mapper.dto.RequestDTO;
import tutorial.com.mapper.model.Client;
import tutorial.com.mapper.model.Credit;
import tutorial.com.mapper.model.Record;
import tutorial.com.mapper.model.Request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ModelMapper mapper = Mappers.getMapper(ModelMapper.class);

        Credit credit = Credit.builder()
                .amount(BigDecimal.TEN)
                .date(LocalDate.now())
                .build();

        Record record = Record.builder()
                .delay(10)
                .history("some history")
                .build();

        Client client = Client.builder()
                .birthDate(LocalDate.now())
                .firstName("andrey")
                .secondName("zherdev")
                .build();

        Request request = Request.builder()
                .credit(credit)
                .client(client)
                .date("2020.10.10")
                .build();

        RequestDTO requestDTO = mapper.requestToRequestDTO(request);

    }

}
