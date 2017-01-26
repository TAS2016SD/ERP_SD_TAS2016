using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Models.Repositories;
using TAS2016.Models;
using Microsoft.AspNetCore.Mvc;

namespace TAS2016.Controllers
{
    public class ClientDiscountController
    {

        private readonly ClientDiscountRepository _repository;
        public ClientDiscountController(ClientDiscountRepository repository)
        {
            this._repository = repository;
        }

        [Route("clientdiscount")]
        public IEnumerable<ClientDiscount> GetAll()
        {
            return _repository.GetAll();
        }

        [Route("clientdiscount/{id}")]
        public ClientDiscount Id(Client Client)
        {
            return _repository.Get(Client);
        }

        [HttpPost]
        [Route("clientdiscount")]
        public void Post([FromBody]ClientDiscount clientDiscount)
        {
            _repository.Add(clientDiscount);
        }

        [HttpPut]
        [Route("clientdiscount/{id}")]
        public void Put(Client Client, [FromBody]ClientDiscount clientDiscount)
        {
            clientDiscount.Client = Client;
            _repository.Update(clientDiscount);
        }

        [HttpDelete]
        [Route("clientdiscount/{id}")]
        public void Delete(Client Client)
        {
            _repository.Delete(Client);
        }
    }
}
