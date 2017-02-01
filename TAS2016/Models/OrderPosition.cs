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
        public int Id { get; set; }
        [Required]
        public int MaterialId { get; set;}
        public Material Material { get; set; }
        [Required]
        public double Amount { get; set; }
        [Required]
        public decimal Price { get; set; }
    }
}
