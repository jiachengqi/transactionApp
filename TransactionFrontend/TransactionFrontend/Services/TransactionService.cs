using System;
using System.Net.Http.Json;
using TransactionFrontend.Models;

namespace TransactionFrontend.Services
{
    public class TransactionService : ITransactionService
    {
        private readonly HttpClient _httpClient;
        private const string ApiUrl = "api/transactions";

        public TransactionService(HttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        public async Task<List<TransactionDto>> GetAllTransactionsAsync()
        {
            return await _httpClient.GetFromJsonAsync<List<TransactionDto>>(ApiUrl);
        }

        public async Task<TransactionDto> GetTransactionByIdAsync(long id)
        {
            var response = await _httpClient.GetAsync($"{ApiUrl}/{id}");
            if (response.IsSuccessStatusCode)
            {
                return await response.Content.ReadFromJsonAsync<TransactionDto>();
            }
            return null;
        }

        public async Task<TransactionDto> CreateTransactionAsync(CreateTransactionDto transaction)
        {
            var response = await _httpClient.PostAsJsonAsync(ApiUrl, transaction);
            response.EnsureSuccessStatusCode();
            return await response.Content.ReadFromJsonAsync<TransactionDto>();
        }
    }
}

