CREATE TABLE [dbo].[Zlecenia_poz]
(
	[Id_zlecenia] INT NOT NULL PRIMARY KEY, 
    [Id_materialu] INT NOT NULL, 
    [ilość] FLOAT NOT NULL, 
    [Cena ] MONEY NOT NULL, 
)