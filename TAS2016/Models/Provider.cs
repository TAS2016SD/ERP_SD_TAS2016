using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class Provider
    {
        [Required]
        [Key]
        public int Id { get; set; }
        [Required]
        public string ProviderName { get; set; }
        [Required]
        public string Adress { get; set; }
        [EmailAddress]
        public string EmailAdress { get; set; }
        [Phone]
        public string PhoneNumber { get; set; }
    }
}
