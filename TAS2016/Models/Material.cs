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
        public int Id { get; set; }
        [Required]
        public string Name { get; set; }
        [Required]
        public decimal BasePrice { get; set; }
        public string PriceUnit { get; set; }
        public int Lenght { get; set; }
        public int Width { get; set; }
        public int Height { get; set; }
        public int Weight { get; set; }
    }
}
