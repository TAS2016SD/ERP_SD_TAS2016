﻿using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using TAS2016.Data;

namespace TAS2016.Migrations
{
    [DbContext(typeof(ERPDbContext))]
    partial class ERPDbContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
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

            modelBuilder.Entity("TAS2016.Models.Material", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<decimal>("BasePrice");

                    b.Property<int>("Height");

                    b.Property<int>("Lenght");

                    b.Property<string>("Name")
                        .IsRequired();

                    b.Property<string>("PriceUnit");

                    b.Property<int>("VatRate");

                    b.Property<int>("Weight");

                    b.Property<int>("Width");

                    b.HasKey("Id");

                    b.ToTable("Materials");
                });

            modelBuilder.Entity("TAS2016.Models.WarehouseStatus", b =>
                {
                    b.Property<string>("StoragePlace")
                        .ValueGeneratedOnAdd();

                    b.Property<double>("Amount");

                    b.Property<int?>("MaterialId");

                    b.HasKey("StoragePlace");

                    b.HasIndex("MaterialId");

                    b.ToTable("WarehouseStatus");
                });

            modelBuilder.Entity("TAS2016.Models.WarehouseStatus", b =>
                {
                    b.HasOne("TAS2016.Models.Material", "Material")
                        .WithMany()
                        .HasForeignKey("MaterialId");
                });
        }
    }
}
