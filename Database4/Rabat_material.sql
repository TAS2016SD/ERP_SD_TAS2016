CREATE TABLE [dbo].[Rabat_material]
(
	[Id_materialu] INT NOT NULL PRIMARY KEY, 
    [Id_rabatu] INT NOT NULL,

	CONSTRAINT [FK_Rabaty_material_ToRabaty] FOREIGN KEY ([Id_rabatu]) REFERENCES [Rabaty]([Id]),
	CONSTRAINT [FK_Rabaty_material_ToMaterialy] FOREIGN KEY ([Id_materialu]) REFERENCES [Materialy]([Id])
)
