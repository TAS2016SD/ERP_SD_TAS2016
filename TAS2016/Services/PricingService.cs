using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Models;
using TAS2016.Data;

namespace TAS2016.Services
{
    public class PricingService
    {
        private readonly ERPDbContext _ERPDbContext;
        
        public PricingService(ERPDbContext ERPDbContext)
        {
            _ERPDbContext = ERPDbContext;
        }

        public decimal GetVatValue(int MaterialId,int ClientId)
        {

        }

    }
}
