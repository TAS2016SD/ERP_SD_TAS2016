using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Models.Repositories;
using TAS2016.Models;
using Microsoft.AspNetCore.Mvc;

namespace TAS2016.Controllers
{
    public class InvoiceController
    {

        private readonly InvoiceRepository _repository;
        public InvoiceController(InvoiceRepository repository)
        {
            this._repository = repository;
        }

        [Route("invoice")]
        public IEnumerable<Invoice> GetAll()
        {
            return _repository.GetAll();
        }

        [Route("invoice/{invoiceId}")]
        public Invoice  Id(int invoiceId)
        {
            return _repository.Get(invoiceId);
        }

        [HttpPost]
        [Route("invoice")]
        public void Post([FromBody]Invoice invoice)
        {
            _repository.Add(invoice);
        }

        [HttpPut]
        [Route("invoice /{invoiceId}")]
        public void Put(int InvoiceId, [FromBody]Invoice invoice)
        {
            invoice.Id = InvoiceId;
            _repository.Update(invoice);
        }

        [HttpDelete]
        [Route("invoice/{invoiceId}")]
        public void Delete(int invoiceId)
        {
            _repository.Delete(invoiceId);
        }
    }
}