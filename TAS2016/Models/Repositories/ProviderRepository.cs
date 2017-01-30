using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Data;

namespace TAS2016.Models.Repositories
{
    public class ProviderRepository
    {
        private readonly ERPDbContext _dbContext;

        public ProviderRepository(ERPDbContext dbContext)
        {
            this._dbContext = dbContext;
        }
        public void Add(Provider Provider)
        {
            _dbContext.Providers.Add(Provider);
            _dbContext.SaveChanges();

        }

        public void Delete(int id)
        {
            Provider ProviderToDelete = _dbContext.Providers.Where(c => c.Id == id).Single();
            _dbContext.Providers.Remove(ProviderToDelete);
            _dbContext.SaveChanges();
        }

        public Provider Get(int Id)
        {
            return _dbContext.Providers.Where(c => c.Id == Id).Single();
        }

        public IEnumerable<Provider> ListAll()
        {
            return _dbContext.Providers.ToList();
        }

        public void Update(Provider provider)
        {
            _dbContext.Providers.Update(provider);
            _dbContext.SaveChanges();
        }
    }
}
