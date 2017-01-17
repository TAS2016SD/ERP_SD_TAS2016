using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using TAS2016.Data;

namespace TAS2016.Migrations
{
    [DbContext(typeof(ERPDbContext))]
    [Migration("20170116202857_matt")]
    partial class matt
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
            modelBuilder
                .HasAnnotation("ProductVersion", "1.1.0-rtm-22752")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("TAS2016.Models.Client", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Adress")
                        .IsRequired();

                    b.Property<string>("EmailAdress");

                    b.Property<string>("NIP")
                        .IsRequired()
                        .HasMaxLength(10);

                    b.Property<string>("Name")
                        .IsRequired();

                    b.Property<string>("PhoneNumber");

                    b.Property<byte>("VAT");

                    b.HasKey("Id");

                    b.ToTable("Clients");
                });
        }
    }
}
