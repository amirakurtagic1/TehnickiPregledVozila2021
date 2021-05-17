BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Korisnik" (
	"id"	INTEGER NOT NULL,
	"ime"	TEXT NOT NULL,
	"prezime"	TEXT NOT NULL,
	"ime_oca"	TEXT NOT NULL,
	"jmbg"	INTEGER NOT NULL,
	"datum_polaganja_strucnog_ispita"	DATE,
	"mjesto_polaganja_strucnog_ispita"	TEXT,
	"broj_licence"	INTEGER,
	"datum_roka_vazenja_licence"	DATE NOT NULL,
	"tip"	TEXT NOT NULL
);
COMMIT;