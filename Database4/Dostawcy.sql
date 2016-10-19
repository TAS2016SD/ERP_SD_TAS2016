CREATE TABLE [dbo].[Dostawcy]
(
	[Id] INT NOT NULL PRIMARY KEY, 
    [Nazwa_dostawcy] NCHAR(50) NOT NULL, 
    [Adres] NCHAR(50) NOT NULL, 
    [Adres_email] NCHAR(30) NULL, 
    [Telefon] NUMERIC NULL, 
)
