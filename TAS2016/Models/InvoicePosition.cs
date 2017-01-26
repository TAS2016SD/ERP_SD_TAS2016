using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace TAS2016.Models
{
    public class InvoicePosition
    {
        [Required]
        [Key]
        public int Id { get; set; }
        [Required]
        public Material Material { get; set; }
        
        public double Amount { get; set; }
        

        public decimal VatAmount { get; set; }

        public decimal Price { get; set; }

        public virtual ICollection<InvoicePosition> Positions { get; set; }
    }
}
