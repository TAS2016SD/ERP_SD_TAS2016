using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Data;
using Microsoft.EntityFrameworkCore;

namespace TAS2016.Models.Repositories
{
    public class MaterialDiscountRepository
    {
        private readonly ERPDbContext _dbContext;

        public MaterialDiscountRepository(ERPDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public void Add(MaterialDiscount MaterialDiscount)
        {
            _dbContext.MaterialDiscounts.Add(MaterialDiscount);
            _dbContext.SaveChanges();
        }

        public void Delete(int MaterialId)
        {
            MaterialDiscount cd = _dbContext.MaterialDiscounts.
                Where(c => c.MaterialId == MaterialId).Single();
            _dbContext.MaterialDiscounts.Remove(cd);
            _dbContext.SaveChanges();
        }

        public void Update(MaterialDiscount MaterialDiscount)
        {
            _dbContext.MaterialDiscounts.Update(MaterialDiscount);
            _dbContext.SaveChanges();
        }

        public MaterialDiscount Get(int MaterialId)
        {
            return _dbContext.MaterialDiscounts.Include(m => m.Discount).Where(c => c.MaterialId == MaterialId).Single();
        }

        public IEnumerable<MaterialDiscount> GetAll()
        {
            return _dbContext.MaterialDiscounts.Include(m => m.Discount);
        }
    }
}
