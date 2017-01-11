using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class MaterialDiscount
    {
        [Required]
        [Key]
        Material Material { get; set; }
        [Required]
        Discount Discount { get; set; }
    }
}
