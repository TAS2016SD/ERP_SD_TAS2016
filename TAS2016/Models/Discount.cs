using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class Discount
    {
        [Required]
        [Key]
        int Id { get; set; }
        [Required]
        int Amount { get; set; }
        [Required]
        string Base { get; set; }
        [Required]
        DateTime StartDate { get; set; }
        [Required]
        DateTime EndDate { get; set; }
    }
}
