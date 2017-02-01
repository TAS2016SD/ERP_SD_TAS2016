using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Data;
using TAS2016.Models;
using Microsoft.EntityFrameworkCore;
namespace TAS2016.Models.Repositories
{
    public class OrderRepository
    {
        
            private readonly ERPDbContext _dbContext;

            public OrderRepository(ERPDbContext dbContext)
            {
                _dbContext = dbContext;
            }

            public void Add(Order Order)
            {
                _dbContext.Orders.Add(Order);
                _dbContext.SaveChanges();
            }

            public void Delete(int orderId)
            {
                Order cd = _dbContext.Orders.
                    Where(c => c.Id == orderId).Single();
                _dbContext.Orders.Remove(cd);
                _dbContext.SaveChanges();
            }

            public void Update(Order Order)
            {
                _dbContext.Orders.Update(Order);
                _dbContext.SaveChanges();
            }

            public Order Get(int OrderId)
            {
                return _dbContext.Orders.Include(m => m.Client).Include(m => m.Seller).Include(m => m.Positions).Where(c => c.Id == OrderId).Single();
            }

            public IEnumerable<Order> GetAll()
            {

           
          
           
                return _dbContext.Orders.Include(m => m.Positions).Include(m => m.Client).Include(m=> m.Seller) ;
            }
        }
    }

