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
    
    public class MaterialController : Controller
    {   
        private readonly MaterialRepository _repository;

        public MaterialController(MaterialRepository _repository)
        {
            this._repository = _repository;
        }

        // GET: /material/getAll
       
        [Route("material")]
        public IEnumerable<Material> GetAll()
        {
            
         return _repository.GetAll();

        }

        // GET material/2
        [Route("material/{id}")]
        public Material Id(int id)
        {


            return _repository.Get(id);
        }

       
        [HttpPost]
        [Route("material")]
        public void Post([FromBody] Material value)
        {
            _repository.Add(value);
        }

        // PUT api/values/5s
        [HttpPut]
        [Route("material/{id}")]
        public void Put(int id,[FromBody]Material value)
        {
            value.Id = id;
            _repository.Update(value);
        }

        // DELETE api/values/5
        [HttpDelete]
        [Route("material/{id}")]
        public void Delete(int id)
        {
            _repository.Delete(id);
        }
    }
}
