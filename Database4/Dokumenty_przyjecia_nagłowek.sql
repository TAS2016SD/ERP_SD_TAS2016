CREATE TABLE [dbo].[Dokumenty_przyjecia_nagłowek]
(
	[Id] INT NOT NULL PRIMARY KEY, 
    [Dostawca] INT NOT NULL, 
    [Data_przyjęcia] DATETIME NOT NULL, 
    CONSTRAINT [FK_Dokumenty_przyjecia_nagłowek_ToDostawcy] FOREIGN KEY ([Dostawca]) REFERENCES [Dostawcy]([Id])
)