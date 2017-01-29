using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Data;

namespace TAS2016.Models.Repositories
{
    public class ClientDiscountRepository
    {
        private readonly ERPDbContext _dbContext;

        public ClientDiscountRepository(ERPDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public void Add(ClientDiscount ClientDiscount)
        {
            _dbContext.ClientDiscounts.Add(ClientDiscount);
            _dbContext.SaveChanges();
        }

        public void Delete(int ClientId)
        {
            ClientDiscount cd = _dbContext.ClientDiscounts.
                Where(c => c.ClientId == ClientId).Single();
            _dbContext.ClientDiscounts.Remove(cd);
            _dbContext.SaveChanges();
        }

        public void Update(ClientDiscount ClientDiscount)
        {
            _dbContext.ClientDiscounts.Update(ClientDiscount);
            _dbContext.SaveChanges();
        }

        public ClientDiscount Get(int ClientId)
        {
            return _dbContext.ClientDiscounts.Where(c => c.ClientId == ClientId).Single();
        }

        public IEnumerable<ClientDiscount> GetAll()
        {
            return _dbContext.ClientDiscounts.ToList();
        }
    }
}
