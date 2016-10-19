CREATE TABLE [dbo].[Stan_magazynu]
(
	[Miejsce_skladowania] NCHAR(10) NOT NULL, 
    [Id_Materialu] INT NULL, 
    [Ilość] FLOAT NULL, 
    CONSTRAINT [PK_Table1] PRIMARY KEY ([Miejsce_skladowania]), 
    CONSTRAINT [FK_Status_magazynuToMaterialy] FOREIGN KEY ([Id_Materialu]) REFERENCES [Materialy]([Id]) 
)
