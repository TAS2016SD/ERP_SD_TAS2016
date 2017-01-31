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
        
        public int Id { get; set; }
        [Required]
        public string Name { get; set; }
        [Required]
        public string Adress { get; set; }
        [EmailAddress]
        public string EmailAdress { get; set; }
        [Phone]
        public string PhoneNumber { get; set; }
        [Required]
        [MinLength(10)]
        [MaxLength(10)]
        public string NIP { get; set; }
        [Required]
        public byte VAT { get; set; }
    }
}
