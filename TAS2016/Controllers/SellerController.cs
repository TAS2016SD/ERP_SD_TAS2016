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

    public class SellerController : Controller
    {
        private readonly SellerRepository _repository;

        public SellerController(SellerRepository _repository)
        {
            this._repository = _repository;
        }

        // GET: /material/getAll

        [Route("seller")]
        public IEnumerable<Seller> GetAll()
        {

            return _repository.GetAll();

        }

        // GET material/2
        [Route("Seller/{id}")]
        public Seller Id(int id)
        {


            return _repository.Get(id);
        }


        [HttpPost]
        [Route("Seller")]
        public void Post([FromBody] Seller value)
        {
            _repository.Add(value);
        }

        // PUT api/values/5s
        [HttpPut]
        [Route("seller/{id}")]
        public void Put(int id, [FromBody]Seller value)
        {
            value.Id = id;
            _repository.Update(value);
        }

        // DELETE api/values/5
        [HttpDelete]
        [Route("seller/{id}")]
        public void Delete(int id)
        {
            _repository.Delete(id);
        }
    }
}
