using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
namespace TAS2016.Models
{
    public class Invoice_header
    {
        [Required]
        [Key]
        int Id { get; set; }
        [Required]
        Client Client { get; set; }
        [Required]
        Seller Seller { get; set; }
        DateTime InvoiceDate { get; set; }
    }
}
