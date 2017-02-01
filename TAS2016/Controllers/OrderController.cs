using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Models.Repositories;
using TAS2016.Models;
using Microsoft.AspNetCore.Mvc;

namespace TAS2016.Controllers
{
    public class OrderController
    {

        private readonly OrderRepository _repository;
        public OrderController(OrderRepository repository)
        {
            this._repository = repository;
        }

        [Route("order")]
        public IEnumerable<Order> GetAll()
        {

            

            return _repository.GetAll();

        }

        [Route("mobile/order")]
        public Order Mobile()
        {
            return _repository.GetNot();
        }

        [Route("order/{orderId}")]
        public Order Id(int orderId)
        {
            return _repository.Get(orderId);
        }

        [HttpPost]
        [Route("order")]
        public void Post([FromBody]Order order)
        {
            _repository.Add(order);
        }

        [HttpPut]
        [Route("order/{orderId}")]
        public void Put(int OrderId, [FromBody]Order order)
        {
            order.Id = OrderId;
            _repository.Update(order);
        }

        [HttpDelete]
        [Route("order/{orderId}")]
        public void Delete(int OrderId)
        {
            _repository.Delete(OrderId);
        }
    }
}