using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using TAS2016.Models;

namespace TAS2016.Data
{
    public class ERPDbContext:DbContext
    {
        public ERPDbContext(DbContextOptions<ERPDbContext> options):base(options)
        { }

        public DbSet<Client> Clients { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Client>().ToTable("Clients");
        }


    }
}
