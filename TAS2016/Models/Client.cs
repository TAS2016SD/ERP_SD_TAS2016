using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class Client
    {
        [Required]
        [Key]
        int Id { get; set; }
        [Required]
        string Name { get; set; }
        [Required]
        string Adress { get; set; }
        string EmailAdress { get; set; }
        string PhoneNumber { get; set; }
        [Required]
        string NIP { get; set; }
        [Required]
        byte VAT { get; set; }
    }
}
