using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using TAS2016.Data;
using System.Collections;
using TAS2016.Models;
using TAS2016.Models.Repositories;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace TAS2016.Controllers
{

    public class ProviderController : Controller
    {
        private readonly ProviderRepository _repository;

        public ProviderController(ProviderRepository _repository)
        {
            this._repository = _repository;
        }

        // GET: /material/getAll

        [Route("provider")]
        public IEnumerable<Provider> GetAll()
        {

            return _repository.GetAll();

        }

        // GET material/2
        [Route("provider/{id}")]
        public Provider Id(int id)
        {


            return _repository.Get(id);
        }


        [HttpPost]
        [Route("provider")]
        public void Post([FromBody] Provider value)
        {
            _repository.Add(value);
        }

        // PUT api/values/5s
        [HttpPut]
        [Route("provider/{id}")]
        public void Put(int id, [FromBody]Provider value)
        {
            value.Id = id;
            _repository.Update(value);
        }

        // DELETE api/values/5
        [HttpDelete]
        [Route("provider/{id}")]
        public void Delete(int id)
        {
            _repository.Delete(id);
        }
    }
}
