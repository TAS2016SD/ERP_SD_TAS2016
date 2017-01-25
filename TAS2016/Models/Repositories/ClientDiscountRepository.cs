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

        public void Delete(Client Client)
        {
            ClientDiscount cd = _dbContext.ClientDiscounts.
                Where(c => c.Client == Client).Single();
            _dbContext.ClientDiscounts.Remove(cd);
            _dbContext.SaveChanges();
        }

        public void Update(ClientDiscount ClientDiscount)
        {
            _dbContext.ClientDiscounts.Update(ClientDiscount);
            _dbContext.SaveChanges();
        }

        public ClientDiscount Get(Client Client)
        {
            return _dbContext.ClientDiscounts.Where(c => c.Client == Client).Single();
        }

        public IEnumerable<ClientDiscount> GetAll()
        {
            return _dbContext.ClientDiscounts.ToList();
        }
    }
}
