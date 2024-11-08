using System.Net.Http.Json;
using TransactionFrontend.Models;

namespace TransactionFrontend.Services
{
    public class TransactionService : ITransactionService
    {
        private readonly HttpClient _httpClient;
        private readonly ILogger<TransactionService> _logger;
        private const string ApiUrl = "api/transactions";

        public TransactionService(HttpClient httpClient, ILogger<TransactionService> logger)
        {
            _httpClient = httpClient;
            _logger = logger;
        }

        public async Task<List<TransactionDto>> GetAllTransactionsAsync()
        {
            try
            {
                return await _httpClient.GetFromJsonAsync<List<TransactionDto>>(ApiUrl);
            }
            catch (Exception ex)
            {
                throw new ApplicationException("error fetching transactions", ex);
            }
        }

        public async Task<TransactionDto> GetTransactionByIdAsync(long id)
        {
            try
            {
                return await _httpClient.GetFromJsonAsync<TransactionDto>($"{ApiUrl}/{id}");
            }
            catch (HttpRequestException ex) when (ex.StatusCode == System.Net.HttpStatusCode.NotFound)
            {
                return null;
            }
            catch (Exception ex)
            {
                throw new ApplicationException($"error fetching transaction id {id}", ex);
            }
        }

        public async Task<TransactionDto> CreateTransactionAsync(CreateTransactionDto transaction)
        {
            try
            {
                var response = await _httpClient.PostAsJsonAsync(ApiUrl, transaction);
                response.EnsureSuccessStatusCode();
                _logger.LogInformation("Created a new transaction with details: Amount = {Amount}, Type = {TransactionType}, Status = {Status}, Currency = {Currency}.",transaction.Amount,transaction.TransactionType,transaction.Status,transaction.Currency);
                return await response.Content.ReadFromJsonAsync<TransactionDto>();
            }
            catch (Exception ex)
            {
                throw new ApplicationException("error creating transaction", ex);
            }
        }
    }
}

