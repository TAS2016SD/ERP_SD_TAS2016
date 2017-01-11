﻿using System;
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
        int Id { get; set; }
        [Required]
        string ProviderName { get; set; }
        [Required]
        string Adress { get; set; }
        [EmailAddress]
        string EmailAdress { get; set; }
        [Phone]
        string PhoneNumber { get; set; }
    }
}
