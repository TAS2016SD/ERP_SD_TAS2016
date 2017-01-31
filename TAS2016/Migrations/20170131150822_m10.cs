using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Metadata;

namespace TAS2016.Migrations
{
    public partial class m10 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_MaterialDiscount_Discount_DiscountId",
                table: "MaterialDiscount");

            migrationBuilder.DropForeignKey(
                name: "FK_MaterialDiscount_Materials_MaterialId1",
                table: "MaterialDiscount");

            migrationBuilder.DropPrimaryKey(
                name: "PK_MaterialDiscount",
                table: "MaterialDiscount");

            migrationBuilder.RenameTable(
                name: "MaterialDiscount",
                newName: "MaterialDiscounts");

            migrationBuilder.RenameIndex(
                name: "IX_MaterialDiscount_MaterialId1",
                table: "MaterialDiscounts",
                newName: "IX_MaterialDiscounts_MaterialId1");

            migrationBuilder.RenameIndex(
                name: "IX_MaterialDiscount_DiscountId",
                table: "MaterialDiscounts",
                newName: "IX_MaterialDiscounts_DiscountId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_MaterialDiscounts",
                table: "MaterialDiscounts",
                column: "MaterialId");

            migrationBuilder.CreateTable(
                name: "Invoice",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    ClientId = table.Column<int>(nullable: false),
                    InvoiceDate = table.Column<DateTime>(nullable: false),
                    SellerId = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Invoice", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Invoice_Clients_ClientId",
                        column: x => x.ClientId,
                        principalTable: "Clients",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Invoice_Sellers_SellerId",
                        column: x => x.SellerId,
                        principalTable: "Sellers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Orders",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    ClientId = table.Column<int>(nullable: false),
                    CreationDate = table.Column<DateTime>(nullable: false),
                    Creator = table.Column<string>(nullable: true),
                    OrderPrice = table.Column<decimal>(nullable: false),
                    PayerId = table.Column<int>(nullable: true),
                    SellerId = table.Column<int>(nullable: false),
                    Status = table.Column<string>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Orders", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Orders_Clients_ClientId",
                        column: x => x.ClientId,
                        principalTable: "Clients",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Orders_Clients_PayerId",
                        column: x => x.PayerId,
                        principalTable: "Clients",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_Orders_Sellers_SellerId",
                        column: x => x.SellerId,
                        principalTable: "Sellers",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "InvoicePosition",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    Amount = table.Column<double>(nullable: false),
                    InvoiceId = table.Column<int>(nullable: true),
                    MaterialId = table.Column<int>(nullable: false),
                    Price = table.Column<decimal>(nullable: false),
                    VatAmount = table.Column<decimal>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_InvoicePosition", x => x.Id);
                    table.ForeignKey(
                        name: "FK_InvoicePosition_Invoice_InvoiceId",
                        column: x => x.InvoiceId,
                        principalTable: "Invoice",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_InvoicePosition_Materials_MaterialId",
                        column: x => x.MaterialId,
                        principalTable: "Materials",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "OrderPosition",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    Amount = table.Column<double>(nullable: false),
                    MaterialId = table.Column<int>(nullable: false),
                    OrderId = table.Column<int>(nullable: true),
                    Price = table.Column<decimal>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_OrderPosition", x => x.Id);
                    table.ForeignKey(
                        name: "FK_OrderPosition_Materials_MaterialId",
                        column: x => x.MaterialId,
                        principalTable: "Materials",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_OrderPosition_Orders_OrderId",
                        column: x => x.OrderId,
                        principalTable: "Orders",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Invoice_ClientId",
                table: "Invoice",
                column: "ClientId");

            migrationBuilder.CreateIndex(
                name: "IX_Invoice_SellerId",
                table: "Invoice",
                column: "SellerId");

            migrationBuilder.CreateIndex(
                name: "IX_InvoicePosition_InvoiceId",
                table: "InvoicePosition",
                column: "InvoiceId");

            migrationBuilder.CreateIndex(
                name: "IX_InvoicePosition_MaterialId",
                table: "InvoicePosition",
                column: "MaterialId");

            migrationBuilder.CreateIndex(
                name: "IX_Orders_ClientId",
                table: "Orders",
                column: "ClientId");

            migrationBuilder.CreateIndex(
                name: "IX_Orders_PayerId",
                table: "Orders",
                column: "PayerId");

            migrationBuilder.CreateIndex(
                name: "IX_Orders_SellerId",
                table: "Orders",
                column: "SellerId");

            migrationBuilder.CreateIndex(
                name: "IX_OrderPosition_MaterialId",
                table: "OrderPosition",
                column: "MaterialId");

            migrationBuilder.CreateIndex(
                name: "IX_OrderPosition_OrderId",
                table: "OrderPosition",
                column: "OrderId");

            migrationBuilder.AddForeignKey(
                name: "FK_MaterialDiscounts_Discount_DiscountId",
                table: "MaterialDiscounts",
                column: "DiscountId",
                principalTable: "Discount",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_MaterialDiscounts_Materials_MaterialId1",
                table: "MaterialDiscounts",
                column: "MaterialId1",
                principalTable: "Materials",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_MaterialDiscounts_Discount_DiscountId",
                table: "MaterialDiscounts");

            migrationBuilder.DropForeignKey(
                name: "FK_MaterialDiscounts_Materials_MaterialId1",
                table: "MaterialDiscounts");

            migrationBuilder.DropTable(
                name: "InvoicePosition");

            migrationBuilder.DropTable(
                name: "OrderPosition");

            migrationBuilder.DropTable(
                name: "Invoice");

            migrationBuilder.DropTable(
                name: "Orders");

            migrationBuilder.DropPrimaryKey(
                name: "PK_MaterialDiscounts",
                table: "MaterialDiscounts");

            migrationBuilder.RenameTable(
                name: "MaterialDiscounts",
                newName: "MaterialDiscount");

            migrationBuilder.RenameIndex(
                name: "IX_MaterialDiscounts_MaterialId1",
                table: "MaterialDiscount",
                newName: "IX_MaterialDiscount_MaterialId1");

            migrationBuilder.RenameIndex(
                name: "IX_MaterialDiscounts_DiscountId",
                table: "MaterialDiscount",
                newName: "IX_MaterialDiscount_DiscountId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_MaterialDiscount",
                table: "MaterialDiscount",
                column: "MaterialId");

            migrationBuilder.AddForeignKey(
                name: "FK_MaterialDiscount_Discount_DiscountId",
                table: "MaterialDiscount",
                column: "DiscountId",
                principalTable: "Discount",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_MaterialDiscount_Materials_MaterialId1",
                table: "MaterialDiscount",
                column: "MaterialId1",
                principalTable: "Materials",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
