package ba.unsa.etf.nrs.projekat;

import java.time.LocalDate;
import java.util.Date;

public class Tehnicar extends Korisnik {
    public Tehnicar(String ime, String prezime, String email, String password, String tipKorisnika, String imeOca, Integer jmbg, LocalDate datumPolaganjaStrucnogIspita, String mjestoPolaganjaStrucnog, String brojLicence, LocalDate rokVazenjaLicence) {
        super(ime, prezime, email, password, tipKorisnika, imeOca, jmbg, datumPolaganjaStrucnogIspita, mjestoPolaganjaStrucnog, brojLicence, rokVazenjaLicence);
    }
}
