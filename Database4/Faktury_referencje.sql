CREATE TABLE [dbo].[Faktury_referencje]
(
	[ID_Faktury] INT NOT NULL PRIMARY KEY, 
    [ID_referencji] INT NOT NULL, 
    CONSTRAINT [FK_Faktury_ToFaktury] FOREIGN KEY ([ID_Faktury]) REFERENCES [Faktury_naglowki]([Id]),
	CONSTRAINT [FK_Faktury_referencje_ToFaktury] FOREIGN KEY ([ID_referencji]) REFERENCES [Faktury_naglowki]([Id])
)