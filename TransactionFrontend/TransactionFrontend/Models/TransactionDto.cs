using System;
namespace TransactionFrontend.Models
{
    public class TransactionDto
    {
        public long Id { get; set; }
        public decimal Amount { get; set; }
        public DateTime Timestamp { get; set; }
        public string TransactionType { get; set; }
        public string Status { get; set; }
        public string Currency { get; set; }
    }

    public class CreateTransactionDto
    {
        public decimal Amount { get; set; }
        public string TransactionType { get; set; }
        public string Status { get; set; }
        public string Currency { get; set; }
    }
}

