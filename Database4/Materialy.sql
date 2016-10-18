CREATE TABLE [dbo].[Materialy]
(
	[Id] INT NOT NULL PRIMARY KEY, 
    [Nazwa] NCHAR(30) NOT NULL, 
    [Cena podstawowa] MONEY NOT NULL, 
    [Jednostka sprzedaży] NCHAR(10) NOT NULL, 
    [Długość] FLOAT NULL, 
    [Szerokość] FLOAT NULL, 
    [Wysokość] FLOAT NULL, 
    [Waga] FLOAT NULL
)
