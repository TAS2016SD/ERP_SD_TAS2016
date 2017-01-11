using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class Material
    {
        [Required]
        [Key]
        int Id { get; set; }
        [Required]
        String Name { get; set; }
        [Required]
        Decimal BasePrice { get; set; }
        String  PriceUnit { get; set; }
        int    Lenght { get; set; }
        int    Width { get; set; }
        int    Height { get; set; }
        int    Weight { get; set; }
    }
}
