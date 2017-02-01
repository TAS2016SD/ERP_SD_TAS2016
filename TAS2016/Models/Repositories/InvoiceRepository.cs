using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Data;
using TAS2016.Models;
using Microsoft.EntityFrameworkCore;
namespace TAS2016.Models.Repositories
{
    public class InvoiceRepository
    {

        private readonly ERPDbContext _dbContext;

        public InvoiceRepository(ERPDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public void Add(Invoice invoice)
        {
            _dbContext.Invoice.Add(invoice);
            _dbContext.SaveChanges();
        }

        public void Delete(int InvoiceId)
        {
            Invoice cd = _dbContext.Invoice.
                Where(c => c.Id == InvoiceId).Single();
            _dbContext.Orders.Remove(cd);
            _dbContext.SaveChanges();
        }

        public void Update(Invoice invoice)
        {
            _dbContext.Invoice.Update(invoice);
            _dbContext.SaveChanges();
        }

        public Invoice  Get(int InvoiceId)
        {
            return _dbContext.Invoice.Include(m => m.Positions).Where(c => c.Id == InvoiceId).Single();
        }

        public IEnumerable<Invoice> GetAll() { 
      
            return _dbContext.Invoice.Include(m => m.Positions);
        }
    }
}
