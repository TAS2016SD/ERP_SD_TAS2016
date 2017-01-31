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
    
    public class ClientController : Controller
    {   
        private readonly ClientRepository _repository;

        public ClientController(ClientRepository _repository)
        {
            this._repository = _repository;
        }

        // GET: /Client/getAll
       
        [Route("client")]
        public IEnumerable<Client> GetAll()
        {
            
         return _repository.ListAll();  
            

        }

        // GET client/2
        [Route("client/{id}")]
        public Client Id(int id)
        {


            return _repository.Get(id);
        }

       
        [HttpPost]
        [Route("client")]
        public void Post([FromBody] Client value)
        {
            _repository.Add(value);
        }

        // PUT api/values/5s
        [HttpPut]
        [Route("client/{id}")]
        public void Put(int id,[FromBody]Client value)
        {
            value.Id = id;
            _repository.Update(value);
        }

        // DELETE api/values/5
        [HttpDelete]
        [Route("client/{id}")]
        public void Delete(int id)
        {
            _repository.Delete(id);
        }
    }
}
