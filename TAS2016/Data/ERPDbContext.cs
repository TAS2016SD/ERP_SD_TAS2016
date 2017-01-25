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
        public DbSet<Material> Materials { get; set; }
        public DbSet<WarehouseStatus> WarehouseStatuses { get; set; }


        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.Entity<Client>();
            modelBuilder.Entity<Material>();
            modelBuilder.Entity<WarehouseStatus>();
            modelBuilder.ForSqlServerUseIdentityColumns();
        }


    }
}
