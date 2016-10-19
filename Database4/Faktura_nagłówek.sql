CREATE TABLE [dbo].[Faktura_nagłówek]
(
	[Id] INT NOT NULL PRIMARY KEY, 
    [Płatnik] INT NOT NULL, 
    [Wystawiający] NCHAR(30) NOT NULL, 
    [Data_wystawienia] DATETIME NOT NULL, 
    CONSTRAINT [FK_Faktura_nagłówek_ToKlienci] FOREIGN KEY ([Płatnik]) REFERENCES [Klienci]([Id]))
