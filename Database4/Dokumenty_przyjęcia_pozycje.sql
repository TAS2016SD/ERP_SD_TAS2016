CREATE TABLE [dbo].[Dokumenty_przyjęcia_pozycje]
(
	[Id_dokumentu] INT NOT NULL PRIMARY KEY, 
    [Id_materialu] INT NULL, 
    [Ilosc] FLOAT NULL, 
    CONSTRAINT [FK_Dokumenty_przyjęcia_pozycje_ToDokumenty_przyjecia_naglowki] FOREIGN KEY ([Id_dokumentu]) REFERENCES [Dokumenty_przyjecia_nagłowek]([Id]), 
    CONSTRAINT [FK_Material] FOREIGN KEY ([Id_materialu]) REFERENCES [Materialy]([Id])
)
