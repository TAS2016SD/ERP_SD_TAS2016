using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace TAS2016.Models
{
    public class Order
    {
        [Required]
        [Key]
        public int Id { get; set; }
        [Required]
        public Client Client { get; set; }
        public Client Payer { get; set; }
        [Required]
        public Seller Seller { get; set; }
        [Required]
        public string Status { get; set; }
        
        public decimal OrderPrice { get; set; }
        [Required]
        public DateTime CreationDate { get; set; }
        
        public string Creator { get; set; }

        public virtual ICollection<OrderPosition> Positions { get; set; }
    }
}
