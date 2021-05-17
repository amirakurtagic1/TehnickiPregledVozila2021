package ba.unsa.etf.nrs.projekat;

import java.time.LocalDate;
import java.util.Date;

public class Tehnicar extends Korisnik {
    public Tehnicar(String ime, String prezime, String imeOca, Integer jmbg, LocalDate datumPolaganjaStrucnogIspita, String mjestoPolaganjaStrucnog, Integer brojLicence, LocalDate rokVazenjaLicence, String tipKorisnika) {
        super(ime, prezime, imeOca, jmbg, datumPolaganjaStrucnogIspita, mjestoPolaganjaStrucnog, brojLicence, rokVazenjaLicence, tipKorisnika);
    }
}
