package frankfurt.transaction.Entity;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {

    private Long id;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;

    private LocalDateTime timestamp;

    @NotNull(message = "Transaction type is required")
    private Transaction.TransactionType transactionType;

    @NotNull(message = "Status is required")
    private Transaction.Status status;

    @NotNull(message = "Currency is required")
    private Transaction.Currency currency;
}