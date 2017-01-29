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

        [Route("clientdiscount/{ClientId}")]
        public ClientDiscount Id(int ClientId)
        {
            return _repository.Get(ClientId);
        }

        [HttpPost]
        [Route("clientdiscount")]
        public void Post([FromBody]ClientDiscount clientDiscount)
        {
            _repository.Add(clientDiscount);
        }

        [HttpPut]
        [Route("clientdiscount/{ClientId}")]
        public void Put(int ClientId, [FromBody]ClientDiscount clientDiscount)
        {
            clientDiscount.ClientId = ClientId;
            _repository.Update(clientDiscount);
        }

        [HttpDelete]
        [Route("clientdiscount/{ClientId}")]
        public void Delete(int ClientId)
        {
            _repository.Delete(ClientId);
        }
    }
}
