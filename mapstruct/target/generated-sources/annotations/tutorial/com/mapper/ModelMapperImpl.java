package tutorial.com.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import tutorial.com.mapper.dto.CreditDTO;
import tutorial.com.mapper.dto.CreditDTO.CreditDTOBuilder;
import tutorial.com.mapper.dto.RecordDTO;
import tutorial.com.mapper.dto.RecordDTO.RecordDTOBuilder;
import tutorial.com.mapper.dto.RequestDTO;
import tutorial.com.mapper.dto.RequestDTO.RequestDTOBuilder;
import tutorial.com.mapper.model.Credit;
import tutorial.com.mapper.model.Record;
import tutorial.com.mapper.model.Request;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-23T23:31:52+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class ModelMapperImpl extends ModelMapper {

    @Override
    public RequestDTO requestToRequestDTO(Request request) {
        if ( request == null ) {
            return null;
        }

        RequestDTOBuilder requestDTO = RequestDTO.builder();

        requestDTO.creditDTO( creditToCreditDTO( request.getCredit() ) );
        if ( request.getDate() != null ) {
            requestDTO.localDate( LocalDate.parse( request.getDate(), DateTimeFormatter.ofPattern( "yyyy.MM.dd" ) ) );
        }
        requestDTO.clientDTO( clientToClientDTO( request.getClient() ) );
        requestDTO.recordList( recordListToRecordDTOList( request.getRecordList() ) );

        return requestDTO.build();
    }

    protected CreditDTO creditToCreditDTO(Credit credit) {
        if ( credit == null ) {
            return null;
        }

        CreditDTOBuilder creditDTO = CreditDTO.builder();

        creditDTO.date( credit.getDate() );
        creditDTO.amount( credit.getAmount() );

        return creditDTO.build();
    }

    protected RecordDTO recordToRecordDTO(Record record) {
        if ( record == null ) {
            return null;
        }

        RecordDTOBuilder recordDTO = RecordDTO.builder();

        recordDTO.history( record.getHistory() );
        recordDTO.delay( record.getDelay() );

        return recordDTO.build();
    }

    protected List<RecordDTO> recordListToRecordDTOList(List<Record> list) {
        if ( list == null ) {
            return null;
        }

        List<RecordDTO> list1 = new ArrayList<RecordDTO>( list.size() );
        for ( Record record : list ) {
            list1.add( recordToRecordDTO( record ) );
        }

        return list1;
    }
}
