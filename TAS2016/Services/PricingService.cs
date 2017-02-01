using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TAS2016.Models;
using TAS2016.Data;
using Microsoft.EntityFrameworkCore;

namespace TAS2016.Services
{
    public class PricingService
    {
        private readonly ERPDbContext _ERPDbContext;

        public PricingService(ERPDbContext ERPDbContext)
        {
            _ERPDbContext = ERPDbContext;
        }

        public decimal GetRabateValue(int MaterialId, int ClientId)
        {
            DateTime now = DateTime.Now;
            Material material;
            try
            {
                material = _ERPDbContext.Materials.Single(m => m.Id == MaterialId);
            }
            catch (Exception e1)
            {
                return 0.0M;
            }
            List<MaterialDiscount> mlist;
            List<ClientDiscount> clist;

            try
            {
                mlist = _ERPDbContext.MaterialDiscounts.Include(m => m.Discount).Where(m => m.MaterialId == MaterialId && m.Discount.EndDate > now).ToList();
                clist = _ERPDbContext.ClientDiscounts.Include(c => c.Discount).Where(c => c.ClientId == ClientId && c.Discount.EndDate > now).ToList();
            }
            catch (Exception e)
            {
                return material.BasePrice;
            }
            decimal rabate = 0.0M;
            mlist.ForEach(m => rabate = +material.BasePrice * (m.Discount.Amount / 100));
            clist.ForEach(m => rabate = +material.BasePrice * (m.Discount.Amount / 100));
            return (material.BasePrice - rabate);

        }

        public Decimal getVatValue(int MaterialId, decimal baseValue)

        {
            Material material;
            try
            {
                material = _ERPDbContext.Materials.Single(m => m.Id == MaterialId);
            }
            catch (Exception e1)
            {
                return 0.0M;
            }

            return ((material.VatRate / 100) * baseValue);
        }
    }


}
