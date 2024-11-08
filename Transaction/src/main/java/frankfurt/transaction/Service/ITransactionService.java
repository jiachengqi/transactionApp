package frankfurt.transaction.Service;

import frankfurt.transaction.Entity.TransactionDTO;

import java.util.List;
import java.util.Optional;

public interface ITransactionService {

    /**
     * Saves a transaction.
     *
     * @param transactionDTO the transaction DTO
     * @return the saved transaction DTO
     */
    TransactionDTO saveTransaction(TransactionDTO transactionDTO);

    /**
     * Retrieves all transactions.
     *
     * @return the list of transaction DTOs
     */
    List<TransactionDTO> getAllTransactions();

    /**
     * Retrieves a transaction by its ID.
     *
     * @param id the transaction ID
     * @return the transaction DTO
     */
    Optional<TransactionDTO> getTransactionById(Long id);
}