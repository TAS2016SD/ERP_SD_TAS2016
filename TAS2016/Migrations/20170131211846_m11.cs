using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore.Migrations;

namespace TAS2016.Migrations
{
    public partial class m11 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_WarehouseStatuses_Materials_MaterialId",
                table: "WarehouseStatuses");

            migrationBuilder.AlterColumn<int>(
                name: "MaterialId",
                table: "WarehouseStatuses",
                nullable: false,
                oldClrType: typeof(int),
                oldNullable: true);

            migrationBuilder.AddForeignKey(
                name: "FK_WarehouseStatuses_Materials_MaterialId",
                table: "WarehouseStatuses",
                column: "MaterialId",
                principalTable: "Materials",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_WarehouseStatuses_Materials_MaterialId",
                table: "WarehouseStatuses");

            migrationBuilder.AlterColumn<int>(
                name: "MaterialId",
                table: "WarehouseStatuses",
                nullable: true,
                oldClrType: typeof(int));

            migrationBuilder.AddForeignKey(
                name: "FK_WarehouseStatuses_Materials_MaterialId",
                table: "WarehouseStatuses",
                column: "MaterialId",
                principalTable: "Materials",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
