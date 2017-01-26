using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Models.Repositories;
using TAS2016.Models;

namespace TAS2016.Controllers
{
    public class WarehouseStatusController : Controller
    {
        private readonly WarehouseStatusRepository _repository;

        public WarehouseStatusController(WarehouseStatusRepository repository)
        {
            this._repository = repository;
        }

        [Route("warehousestatus")]
        public IEnumerable<WarehouseStatus> GetAll()
        {
            return _repository.GetAll();
        }

        [Route("warehousestatus/{id}")]
        public WarehouseStatus Id(string StoragePlace)
        {
            return _repository.GetWarehouseStatus(StoragePlace);
        }

        [HttpPost]
        [Route("warehousestatus")]
        public void Post([FromBody] WarehouseStatus warehouseStatus)
        {
            _repository.Add(warehouseStatus);
        }

        [HttpPut]
        [Route("warehousestatus/{id}")]
        public void Put(string StoragePlace, [FromBody]WarehouseStatus warehouseStatus)
        {
            warehouseStatus.StoragePlace = StoragePlace;
            _repository.Update(warehouseStatus);
        }

        [HttpDelete]
        [Route("warehousestatus/{id}")]
        public void Delete(string StoragePlace)
        {
            _repository.Remove(StoragePlace);
        }
    }
}
