package frankfurt.transaction.Entity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TransactionMapper {

    /**
     * Converts TransactionDTO to Transaction entity.
     *
     * @param dto the transaction DTO
     * @return the transaction entity
     */
    @Mapping(target = "timestamp", ignore = true)
    Transaction toEntity(TransactionDTO dto);

    /**
     * Converts Transaction entity to TransactionDTO.
     *
     * @param entity the transaction entity
     * @return the transaction DTO
     */
    TransactionDTO toDto(Transaction entity);
}