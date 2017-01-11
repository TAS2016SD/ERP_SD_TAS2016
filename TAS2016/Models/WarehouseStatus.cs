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
        string StoragePlace { get; set; }
        Material Material { get; set; }
        double Amount { get; set; }
    }
}
