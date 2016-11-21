CREATE TABLE [dbo].[Faktury_naglowki]
(
	[Id] INT NOT NULL PRIMARY KEY, 
    [Płatnik] INT NOT NULL, 
    [Wystawiający] NCHAR(30) NOT NULL, 
    [Data_wystawienia] DATETIME NOT NULL, 
    [Typ] NCHAR(20) NOT NULL, 
    CONSTRAINT [FK_Faktura_nagłówek_ToKlienci] FOREIGN KEY ([Płatnik]) REFERENCES [Klienci]([Id]))
