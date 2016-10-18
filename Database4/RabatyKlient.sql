CREATE TABLE [dbo].[RabatyKlient]
(
	[Id_klienta] INT NOT NULL PRIMARY KEY, 
    [Id_rabatu] INT NOT NULL, 
    CONSTRAINT [FK_RabatyKlient_ToKlienci] FOREIGN KEY ([Id_klienta]) REFERENCES [Klienci]([Id]), 
    CONSTRAINT [FK_RabatyKlient_ToRabaty] FOREIGN KEY ([Id_rabatu]) REFERENCES [Rabaty]([Id])
)
