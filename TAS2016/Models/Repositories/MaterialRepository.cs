using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Data;

namespace TAS2016.Models.Repositories
{
    public class MaterialRepository
    {
        private readonly ERPDbContext _dbContext;

        public MaterialRepository(ERPDbContext dbContext) {
            _dbContext = dbContext;
        }

        public void Add(Material Material)
        {
            _dbContext.Materials.Add(Material);
            _dbContext.SaveChanges();
        }

        public void Delete(int id)
        {
            Material toDelete = _dbContext.Materials.Where(m => m.Id == id).Single();
            _dbContext.Materials.Remove(toDelete);
            _dbContext.SaveChanges();
        }

        public Material Get(int id)
        {
            return _dbContext.Materials.Where(m => m.Id == id).Single();
        }

        public IEnumerable<Material> GetAll()
        {
            return _dbContext.Materials.ToList();
        } 

        public void Update(Material material)
        {
            _dbContext.Materials.Update(material);
            _dbContext.SaveChanges();
        }


    }
}
