using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Metadata;

namespace TAS2016.Migrations
{
    public partial class m7 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_WarehouseStatus_Materials_MaterialId",
                table: "WarehouseStatus");

            migrationBuilder.DropPrimaryKey(
                name: "PK_WarehouseStatus",
                table: "WarehouseStatus");

            migrationBuilder.RenameTable(
                name: "WarehouseStatus",
                newName: "WarehouseStatuses");

            migrationBuilder.RenameIndex(
                name: "IX_WarehouseStatus_MaterialId",
                table: "WarehouseStatuses",
                newName: "IX_WarehouseStatuses_MaterialId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_WarehouseStatuses",
                table: "WarehouseStatuses",
                column: "StoragePlace");

            migrationBuilder.CreateTable(
                name: "Discount",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    Amount = table.Column<int>(nullable: false),
                    Base = table.Column<string>(nullable: false),
                    EndDate = table.Column<DateTime>(nullable: false),
                    StartDate = table.Column<DateTime>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Discount", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "ClientDiscounts",
                columns: table => new
                {
                    ClientId = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    ClientId1 = table.Column<int>(nullable: false),
                    DiscountId = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_ClientDiscounts", x => x.ClientId);
                    table.ForeignKey(
                        name: "FK_ClientDiscounts_Clients_ClientId1",
                        column: x => x.ClientId1,
                        principalTable: "Clients",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_ClientDiscounts_Discount_DiscountId",
                        column: x => x.DiscountId,
                        principalTable: "Discount",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_ClientDiscounts_ClientId1",
                table: "ClientDiscounts",
                column: "ClientId1");

            migrationBuilder.CreateIndex(
                name: "IX_ClientDiscounts_DiscountId",
                table: "ClientDiscounts",
                column: "DiscountId");

            migrationBuilder.AddForeignKey(
                name: "FK_WarehouseStatuses_Materials_MaterialId",
                table: "WarehouseStatuses",
                column: "MaterialId",
                principalTable: "Materials",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_WarehouseStatuses_Materials_MaterialId",
                table: "WarehouseStatuses");

            migrationBuilder.DropTable(
                name: "ClientDiscounts");

            migrationBuilder.DropTable(
                name: "Discount");

            migrationBuilder.DropPrimaryKey(
                name: "PK_WarehouseStatuses",
                table: "WarehouseStatuses");

            migrationBuilder.RenameTable(
                name: "WarehouseStatuses",
                newName: "WarehouseStatus");

            migrationBuilder.RenameIndex(
                name: "IX_WarehouseStatuses_MaterialId",
                table: "WarehouseStatus",
                newName: "IX_WarehouseStatus_MaterialId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_WarehouseStatus",
                table: "WarehouseStatus",
                column: "StoragePlace");

            migrationBuilder.AddForeignKey(
                name: "FK_WarehouseStatus_Materials_MaterialId",
                table: "WarehouseStatus",
                column: "MaterialId",
                principalTable: "Materials",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
