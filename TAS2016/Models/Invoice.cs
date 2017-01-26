﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
namespace TAS2016.Models
{
    public class Invoice
    {
        [Required]
        [Key]
        public int Id { get; set; }
        [Required]
        public Client Client { get; set; }
        [Required]
        public Seller Seller { get; set; }
        public DateTime InvoiceDate { get; set; }

        
    }
}
