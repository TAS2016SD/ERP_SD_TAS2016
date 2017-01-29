using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class ClientDiscount
    {   [Required]
        [Key]
        public int ClientId;
        [Required]
        public Client Client { get; set; }
        [Required]
        public Discount Discount { get; set; }
    }
}
