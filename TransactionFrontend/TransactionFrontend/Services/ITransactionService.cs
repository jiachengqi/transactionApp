using System;
using TransactionFrontend.Models;

namespace TransactionFrontend.Services
{
	public interface ITransactionService
	{
        Task<List<TransactionDto>> GetAllTransactionsAsync();
        Task<TransactionDto> GetTransactionByIdAsync(long id);
        Task<TransactionDto> CreateTransactionAsync(CreateTransactionDto transaction);
    }
}

