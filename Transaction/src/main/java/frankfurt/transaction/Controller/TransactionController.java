package frankfurt.transaction.Controller;

import frankfurt.transaction.Entity.TransactionDTO;
import frankfurt.transaction.Service.ITransactionService;
import frankfurt.transaction.Util.TransactionNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transaction API", description = "Endpoints for managing transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    private final ITransactionService transactionService;

    /**
     * Constructor for TransactionController
     *
     * @param transactionService the transaction service
     */
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Creates a new transaction.
     *
     * @param transactionDTO the transaction DTO
     * @return the saved transaction DTO
     */
    @Operation(summary = "Create a new transaction", description = "Creates a new transaction with the given details")
    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
        TransactionDTO savedTransaction = transactionService.saveTransaction(transactionDTO);
        logger.info("new transaction created: {}", savedTransaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
    }

    /**
     * Retrieves all transactions.
     *
     * @return the list of transaction DTOs
     */
    @Operation(summary = "Get all transactions", description = "Retrieves a list of all transactions")
    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    /**
     * Retrieves a transaction by its ID.
     *
     * @param id the transaction ID
     * @return the transaction DTO
     */
    @Operation(summary = "Get transaction by ID", description = "Retrieves a transaction by its unique ID")
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
        Optional<TransactionDTO> transactionDTO = transactionService.getTransactionById(id);
        return transactionDTO
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new TransactionNotFoundException("transaction not found id: " + id));
    }
}