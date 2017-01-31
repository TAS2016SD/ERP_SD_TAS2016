using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Data;

namespace TAS2016.Models.Repositories
{
    public class WarehouseStatusRepository
    {
        private readonly ERPDbContext _dbContext;

        public WarehouseStatusRepository(ERPDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public void Add(WarehouseStatus WarehouseStatus)
        {
            _dbContext.WarehouseStatuses.Add(WarehouseStatus);
            _dbContext.SaveChanges();
        }

        public void Remove(string StoragePlace)
        {
            WarehouseStatus ws = _dbContext.WarehouseStatuses.Where(m => m.StoragePlace == StoragePlace).Single();
            _dbContext.Remove(ws);
            _dbContext.SaveChanges();
        }
        
        public void Update(WarehouseStatus WarehouseStatus)
        {
            _dbContext.WarehouseStatuses.Update(WarehouseStatus);
            _dbContext.SaveChanges();
        }

        public  WarehouseStatus GetWarehouseStatus(string StoragePlace)
        {
            return _dbContext.WarehouseStatuses.Include(i => i.Material).Single(M => M.StoragePlace == StoragePlace);

        }

        public IEnumerable<WarehouseStatus> GetAll()
        {
            return _dbContext.WarehouseStatuses.Include(i => i.Material).ToList();
        }
    }
}
