package frankfurt.transaction.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Getter
    private BigDecimal amount;

    @Setter
    @Getter
    private LocalDateTime timestamp;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private Status status;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Transaction(BigDecimal amount, LocalDateTime timestamp, TransactionType transactionType, Status status, Currency currency) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
        this.status = status;
        this.currency = currency;
    }

    // Enums for transaction type, status, and currency
    public enum TransactionType {
        SALE, REFUND
    }

    public enum Status {
        APPROVED, DECLINED, FAILED
    }

    public enum Currency {
        EUR, GBP, INR
    }

    // Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(amount, that.amount) &&
                transactionType == that.transactionType &&
                status == that.status &&
                currency == that.currency &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, transactionType, status, currency, timestamp);
    }

    // Override the `toString` if necessary for logging or debugging
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", transactionType=" + transactionType +
                ", status=" + status +
                ", currency=" + currency +
                '}';
    }
}

