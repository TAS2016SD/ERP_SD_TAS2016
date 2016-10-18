CREATE TABLE [dbo].[Rabaty]
(
	[Id] INT NOT NULL PRIMARY KEY, 
    [Kwota] DECIMAL(12, 2) NOT NULL, 
    [Podstawa ] NCHAR(3) NOT NULL, 
    [Data rozpoczęcia] DATE NOT NULL, 
    [Data zakonczenia] DATE NOT NULL
)
