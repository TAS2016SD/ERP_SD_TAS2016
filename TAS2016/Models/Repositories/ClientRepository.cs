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

        public ClientRepository(ERPDbContext _dbContext)
        {
            this._dbContext = _dbContext;
        }
        public void Add(Client client)
        {
            _dbContext.Clients.Add(client);
                }

        public void Delete(Client client)
        {
            _dbContext.Clients.Remove(client);
        }
  
        public Client get(int Id)
        {
            return null; //_dbContext.Clients.Where(b => b.Id == Id);
        }
   
        public IEnumerable<Client> ListAll()
        {
            throw new NotImplementedException();
        }

        public void Update(Client client)
        {
            throw new NotImplementedException();
        }
    }
}
