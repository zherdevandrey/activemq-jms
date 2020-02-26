package tutorial.com.mapper;


import org.mapstruct.*;
import tutorial.com.mapper.dto.ClientDTO;
import tutorial.com.mapper.dto.RequestDTO;
import tutorial.com.mapper.model.Client;
import tutorial.com.mapper.model.Request;

import java.util.UUID;


@Mapper
public abstract class ModelMapper {

    @Mappings({
            @Mapping(target = "creditDTO", source = "request.credit"),
            @Mapping(target = "clientDTO", source = "request.client"),
            @Mapping(target = "recordList", source = "request.recordList"),
            @Mapping(target = "localDate", source = "request.date", dateFormat = "yyyy.MM.dd")
    })
    public abstract RequestDTO requestToRequestDTO(Request request);

    public ClientDTO clientToClientDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setBirthDate(client.getBirthDate());
        clientDTO.setFullName(client.getFirstName() + " " + client.getSecondName());
        return clientDTO;
    }

    @AfterMapping
    public void setSecret(@MappingTarget RequestDTO requestDTO){
        requestDTO.getCreditDTO().setSecretKey(UUID.randomUUID().toString());
    }
}
