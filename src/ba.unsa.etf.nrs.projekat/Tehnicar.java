package ba.unsa.etf.nrs.projekat;

import java.util.Date;

public class Tehnicar extends Korisnik {
    public Tehnicar(String ime, String prezime, String ime_oca, String mjesto_polaganje_strucnog, String tip_korisnika, Integer jmbg, Integer broj_licence, Date datum_polaganja_strucnog_ispita, Date rok_vazenja_licence) {
        super(ime, prezime, ime_oca, mjesto_polaganje_strucnog, tip_korisnika, jmbg, broj_licence, datum_polaganja_strucnog_ispita, rok_vazenja_licence);
    }
}
