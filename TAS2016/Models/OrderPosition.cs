using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class OrderPosition
    {
        [Required]
        [Key]
        int Id { get; set; }
        [Required]
        Material Material { get; set; }
        [Required]
        double Amount { get; set; }
        [Required]
        decimal Price { get; set; }
    }
}
