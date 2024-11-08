using System.ComponentModel.DataAnnotations;

namespace TransactionFrontend.Models
{
    public class TransactionDto
    {
        public long Id { get; set; }
        [Range(0.01, double.MaxValue, ErrorMessage = "amount must be greater than zero.")]
        public decimal Amount { get; set; }
        public DateTime Timestamp { get; set; }
        [Required]
        public string TransactionType { get; set; }
        [Required]
        public string Status { get; set; }
        [Required]
        public string Currency { get; set; }
    }

    public class CreateTransactionDto
    {
        [Range(0.01, double.MaxValue, ErrorMessage = "amount must be greater than zero.")]
        public decimal Amount { get; set; }
        [Required]
        public string TransactionType { get; set; }
        [Required]
        public string Status { get; set; }
        [Required]
        public string Currency { get; set; }
    }
}

