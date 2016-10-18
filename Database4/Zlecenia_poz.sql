CREATE TABLE [dbo].[Zlecenia_poz]
(
	[Id_zlecenia] INT NOT NULL PRIMARY KEY, 
    [Id_materialu] INT NOT NULL, 
    [ilość] FLOAT NOT NULL, 
    [Cena ] MONEY NOT NULL, 
    CONSTRAINT [FK_Zlecenia_poz_ToZleceniaNag] FOREIGN KEY ([Id_zlecenia]) REFERENCES [ZleceniaNag]([Id]), 
    CONSTRAINT [FK_Zlecenia_poz_ToMaterialy] FOREIGN KEY ([Id_materialu]) REFERENCES [Materialy]([Id]))
