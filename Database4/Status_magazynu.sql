CREATE TABLE [dbo].[Stan_magazynu]
(
	[Miejsce_skladowania] NCHAR(10) NOT NULL, 
    [Id_Materialu] INT NULL, 
    [Ilość] FLOAT NULL, 
    CONSTRAINT [PK_Stan_magazynu] PRIMARY KEY ([Miejsce_skladowania]), 
    CONSTRAINT [FK_Stan_magazynu_To] FOREIGN KEY ([Id_Materialu]) REFERENCES [Materialy]([Id]) ,

    
)
