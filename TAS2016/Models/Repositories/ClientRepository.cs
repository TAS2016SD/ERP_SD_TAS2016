using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Interfaces;
using TAS2016.Data;

namespace TAS2016.Models.Repositories
{
    public class ClientRepository : IClientRepository
    {

        private readonly ERPDbContext _dbContext;

        public ClientRepository(ERPDbContext dbContext)
        {
            this._dbContext = dbContext;
        }
        public void Add(Client client)
        {
            _dbContext.Clients.Add(client);
            _dbContext.SaveChanges();
           
        }

        public void Delete(int id)
        {
            Client ClientToDelete = _dbContext.Clients.Where(c => c.Id == id).Single();
            _dbContext.Clients.Remove(ClientToDelete);
            _dbContext.SaveChanges();
        }
  
        public Client Get(int Id)
        {
          return _dbContext.Clients.Where(c => c.Id == Id).Single();
        }
   
        public IEnumerable<Client> ListAll()
        {
            return _dbContext.Clients.ToList();
        }

        public void Update(Client client)
        {
            _dbContext.Clients.Update(client);
        }
    }
}
