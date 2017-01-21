using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore.Migrations;

namespace TAS2016.Migrations
{
    public partial class Mw : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "MaterialId",
                table: "WarehouseStatus",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_WarehouseStatus_MaterialId",
                table: "WarehouseStatus",
                column: "MaterialId");

            migrationBuilder.AddForeignKey(
                name: "FK_WarehouseStatus_Materials_MaterialId",
                table: "WarehouseStatus",
                column: "MaterialId",
                principalTable: "Materials",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_WarehouseStatus_Materials_MaterialId",
                table: "WarehouseStatus");

            migrationBuilder.DropIndex(
                name: "IX_WarehouseStatus_MaterialId",
                table: "WarehouseStatus");

            migrationBuilder.DropColumn(
                name: "MaterialId",
                table: "WarehouseStatus");
        }
    }
}
