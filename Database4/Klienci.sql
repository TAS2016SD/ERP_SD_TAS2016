CREATE TABLE [dbo].[Klienci]
(
	[Id] INT NOT NULL PRIMARY KEY, 
    [Nazwa_Klienta] NCHAR(50) NOT NULL, 
    [Adres] NCHAR(50) NOT NULL, 
    [Adres_email] NCHAR(30) NULL, 
    [Telefon] NUMERIC NULL, 
    [NIP] NCHAR(13) NOT NULL, 
    [Płatnik_VAT] BIT NOT NULL
)
