using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class WarehouseStatus
    {
        [Required]
        [Key]
        public string StoragePlace { get; set; }
        public int MaterialId { get; set; }
        public Material Material { get; set; }
        public double Amount { get; set; }
    }
}
