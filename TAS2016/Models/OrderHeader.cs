using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class OrderHeader
    {
        [Required]
        [Key]
        int Id { get; set; }
        [Required]
        Client Client { get; set; }
        //Czy nie powinno być osobnej tabeli i osobnego modelu Payers?
        int PayerId { get; set; }
        [Required]
        Seller Seller { get; set; }
        [Required]
        string Status { get; set; }
        [Required]
        decimal OrderPrice { get; set; }
        [Required]
        DateTime CreationDate { get; set; }
        [Required]
        string Creator { get; set; }
    }
}
