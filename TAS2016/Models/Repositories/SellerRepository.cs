using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Data;

namespace TAS2016.Models.Repositories
{
    public class SellerRepository
    {
        private readonly ERPDbContext _dbContext;

        public SellerRepository(ERPDbContext dbContext)
        {
            this._dbContext = dbContext;
        }
        public void Add(Seller seller)
        {
            _dbContext.Sellers.Add(seller);
            _dbContext.SaveChanges();

        }

        public void Delete(int id)
        {
            Seller seller = _dbContext.Sellers.Where(c => c.Id == id).Single();
            _dbContext.Sellers.Remove(seller);
            _dbContext.SaveChanges();
        }

        public IEnumerable<Seller> GetAll()
        {
            return _dbContext.Sellers;
        }

        public Seller Get(int Id)
        {
            return _dbContext.Sellers.Where(c => c.Id == Id).Single();
        }

        

        public void Update(Seller seller)
        {
            _dbContext.Sellers.Update(seller);
            _dbContext.SaveChanges();
        }
    }
}

