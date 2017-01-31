using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Models.Repositories;
using TAS2016.Models;
using Microsoft.AspNetCore.Mvc;

namespace TAS2016.Controllers
{
    public class MaterialDiscountController
    {

        private readonly MaterialDiscountRepository _repository;
        public MaterialDiscountController(MaterialDiscountRepository repository)
        {
            this._repository = repository;
        }

        [Route("materialdiscount")]
        public IEnumerable<MaterialDiscount> GetAll()
        {
            return _repository.GetAll();
        }

        [Route("materialdiscount/{MaterialId}")]
        public MaterialDiscount Id(int MaterialId)
        {
            return _repository.Get(MaterialId);
        }

        [HttpPost]
        [Route("materialdiscount")]
        public void Post([FromBody]MaterialDiscount materialDiscount)
        {
            _repository.Add(materialDiscount);
        }

        [HttpPut]
        [Route("materialdiscount/{MaterialId}")]
        public void Put(int MaterialId, [FromBody]MaterialDiscount materialDiscount)
        {
            materialDiscount.MaterialId = MaterialId;
            _repository.Update(materialDiscount);
        }

        [HttpDelete]
        [Route("materialdiscount/{MaterialId}")]
        public void Delete(int materialId)
        {
            _repository.Delete(materialId);
        }
    }
}
