CREATE TABLE [dbo].[ZleceniaNag]
(
	[Id] INT NOT NULL PRIMARY KEY, 
    [Id_odbiorcy] INT NOT NULL, 
    [Id_platnika] INT NULL, 
    [Id_dostawcy] INT NOT NULL, 
    [Status] NCHAR(15) NOT NULL, 
    [Wartość zlecenia] MONEY NOT NULL, 
    [Data_utworzenia] DATE NOT NULL, 
    [Tworzący] NCHAR(40) NOT NULL
)
