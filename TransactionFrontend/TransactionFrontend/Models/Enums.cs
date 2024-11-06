using System;
namespace TransactionFrontend.Models
{
    public enum TransactionType
    {
        SALE,
        REFUND
    }

    public enum Status
    {
        APPROVED,
        DECLINED,
        FAILED
    }

    public enum Currency
    {
        EUR,
        GBP,
        INR,
        USD
    }
}

