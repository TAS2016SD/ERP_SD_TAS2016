using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using TAS2016.Data;

namespace TAS2016.Migrations
{
    [DbContext(typeof(ERPDbContext))]
    [Migration("20170131211846_m11")]
    partial class m11
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

            modelBuilder.Entity("TAS2016.Models.ClientDiscount", b =>
                {
                    b.Property<int>("ClientId")
                        .ValueGeneratedOnAdd();

                    b.Property<int>("ClientId1");

                    b.Property<int>("DiscountId");

                    b.HasKey("ClientId");

                    b.HasIndex("ClientId1");

                    b.HasIndex("DiscountId");

                    b.ToTable("ClientDiscounts");
                });

            modelBuilder.Entity("TAS2016.Models.Discount", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<int>("Amount");

                    b.Property<string>("Base")
                        .IsRequired();

                    b.Property<DateTime>("EndDate");

                    b.Property<DateTime>("StartDate");

                    b.HasKey("Id");

                    b.ToTable("Discount");
                });

            modelBuilder.Entity("TAS2016.Models.Invoice", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<int>("ClientId");

                    b.Property<DateTime>("InvoiceDate");

                    b.Property<int>("SellerId");

                    b.HasKey("Id");

                    b.HasIndex("ClientId");

                    b.HasIndex("SellerId");

                    b.ToTable("Invoice");
                });

            modelBuilder.Entity("TAS2016.Models.InvoicePosition", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<double>("Amount");

                    b.Property<int?>("InvoiceId");

                    b.Property<int>("MaterialId");

                    b.Property<decimal>("Price");

                    b.Property<decimal>("VatAmount");

                    b.HasKey("Id");

                    b.HasIndex("InvoiceId");

                    b.HasIndex("MaterialId");

                    b.ToTable("InvoicePosition");
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

            modelBuilder.Entity("TAS2016.Models.MaterialDiscount", b =>
                {
                    b.Property<int>("MaterialId")
                        .ValueGeneratedOnAdd();

                    b.Property<int>("DiscountId");

                    b.Property<int?>("MaterialId1");

                    b.HasKey("MaterialId");

                    b.HasIndex("DiscountId");

                    b.HasIndex("MaterialId1");

                    b.ToTable("MaterialDiscounts");
                });

            modelBuilder.Entity("TAS2016.Models.Order", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<int>("ClientId");

                    b.Property<DateTime>("CreationDate");

                    b.Property<string>("Creator");

                    b.Property<decimal>("OrderPrice");

                    b.Property<int?>("PayerId");

                    b.Property<int>("SellerId");

                    b.Property<string>("Status")
                        .IsRequired();

                    b.HasKey("Id");

                    b.HasIndex("ClientId");

                    b.HasIndex("PayerId");

                    b.HasIndex("SellerId");

                    b.ToTable("Orders");
                });

            modelBuilder.Entity("TAS2016.Models.OrderPosition", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<double>("Amount");

                    b.Property<int>("MaterialId");

                    b.Property<int?>("OrderId");

                    b.Property<decimal>("Price");

                    b.HasKey("Id");

                    b.HasIndex("MaterialId");

                    b.HasIndex("OrderId");

                    b.ToTable("OrderPosition");
                });

            modelBuilder.Entity("TAS2016.Models.Provider", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Adress")
                        .IsRequired();

                    b.Property<string>("EmailAdress");

                    b.Property<string>("PhoneNumber");

                    b.Property<string>("ProviderName")
                        .IsRequired();

                    b.HasKey("Id");

                    b.ToTable("Providers");
                });

            modelBuilder.Entity("TAS2016.Models.Seller", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Adress")
                        .IsRequired();

                    b.Property<string>("NIP")
                        .IsRequired()
                        .HasMaxLength(10);

                    b.Property<string>("Name")
                        .IsRequired();

                    b.HasKey("Id");

                    b.ToTable("Sellers");
                });

            modelBuilder.Entity("TAS2016.Models.WarehouseStatus", b =>
                {
                    b.Property<string>("StoragePlace")
                        .ValueGeneratedOnAdd();

                    b.Property<double>("Amount");

                    b.Property<int>("MaterialId");

                    b.HasKey("StoragePlace");

                    b.HasIndex("MaterialId");

                    b.ToTable("WarehouseStatuses");
                });

            modelBuilder.Entity("TAS2016.Models.ClientDiscount", b =>
                {
                    b.HasOne("TAS2016.Models.Client", "Client")
                        .WithMany()
                        .HasForeignKey("ClientId1")
                        .OnDelete(DeleteBehavior.Cascade);

                    b.HasOne("TAS2016.Models.Discount", "Discount")
                        .WithMany()
                        .HasForeignKey("DiscountId")
                        .OnDelete(DeleteBehavior.Cascade);
                });

            modelBuilder.Entity("TAS2016.Models.Invoice", b =>
                {
                    b.HasOne("TAS2016.Models.Client", "Client")
                        .WithMany()
                        .HasForeignKey("ClientId")
                        .OnDelete(DeleteBehavior.Cascade);

                    b.HasOne("TAS2016.Models.Seller", "Seller")
                        .WithMany()
                        .HasForeignKey("SellerId")
                        .OnDelete(DeleteBehavior.Cascade);
                });

            modelBuilder.Entity("TAS2016.Models.InvoicePosition", b =>
                {
                    b.HasOne("TAS2016.Models.Invoice")
                        .WithMany("Positions")
                        .HasForeignKey("InvoiceId");

                    b.HasOne("TAS2016.Models.Material", "Material")
                        .WithMany()
                        .HasForeignKey("MaterialId")
                        .OnDelete(DeleteBehavior.Cascade);
                });

            modelBuilder.Entity("TAS2016.Models.MaterialDiscount", b =>
                {
                    b.HasOne("TAS2016.Models.Discount", "Discount")
                        .WithMany()
                        .HasForeignKey("DiscountId")
                        .OnDelete(DeleteBehavior.Cascade);

                    b.HasOne("TAS2016.Models.Material", "Material")
                        .WithMany()
                        .HasForeignKey("MaterialId1");
                });

            modelBuilder.Entity("TAS2016.Models.Order", b =>
                {
                    b.HasOne("TAS2016.Models.Client", "Client")
                        .WithMany()
                        .HasForeignKey("ClientId")
                        .OnDelete(DeleteBehavior.Cascade);

                    b.HasOne("TAS2016.Models.Client", "Payer")
                        .WithMany()
                        .HasForeignKey("PayerId");

                    b.HasOne("TAS2016.Models.Seller", "Seller")
                        .WithMany()
                        .HasForeignKey("SellerId")
                        .OnDelete(DeleteBehavior.Cascade);
                });

            modelBuilder.Entity("TAS2016.Models.OrderPosition", b =>
                {
                    b.HasOne("TAS2016.Models.Material", "Material")
                        .WithMany()
                        .HasForeignKey("MaterialId")
                        .OnDelete(DeleteBehavior.Cascade);

                    b.HasOne("TAS2016.Models.Order")
                        .WithMany("Positions")
                        .HasForeignKey("OrderId");
                });

            modelBuilder.Entity("TAS2016.Models.WarehouseStatus", b =>
                {
                    b.HasOne("TAS2016.Models.Material", "Material")
                        .WithMany()
                        .HasForeignKey("MaterialId")
                        .OnDelete(DeleteBehavior.Cascade);
                });
        }
    }
}
