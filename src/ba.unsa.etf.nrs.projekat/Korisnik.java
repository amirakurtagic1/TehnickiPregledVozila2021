package ba.unsa.etf.nrs.projekat;

import java.time.LocalDate;
import java.util.Date;

public class Korisnik {
    private String ime, prezime, imeOca, mjestoPolaganjaStrucnog, tipKorisnika, email, brojLicence, password;
    private Integer jmbg;
    private LocalDate datumPolaganjaStrucnogIspita, rokVazenjaLicence;

    public Korisnik(String ime, String prezime, String email, String password, String tipKorisnika, String imeOca, Integer jmbg,LocalDate datumPolaganjaStrucnogIspita,String mjestoPolaganjaStrucnog, String brojLicence, LocalDate rokVazenjaLicence) {
        this.ime = ime;
        this.prezime = prezime;
        this.imeOca = imeOca;
        this.mjestoPolaganjaStrucnog = mjestoPolaganjaStrucnog;
        this.tipKorisnika = tipKorisnika;
        this.email = email;
        this.brojLicence = brojLicence;
        this.jmbg = jmbg;
        this.password = password;
        this.datumPolaganjaStrucnogIspita = datumPolaganjaStrucnogIspita;
        this.rokVazenjaLicence = rokVazenjaLicence;
    }

    public Korisnik(String ime, String prezime, String imeOca, Integer jmbg, String tipKorisnika) {
        this.ime = ime;
        this.prezime = prezime;
        this.imeOca = imeOca;
        this.tipKorisnika = tipKorisnika;
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getImeOca() {
        return imeOca;
    }

    public void setImeOca(String imeOca) {
        this.imeOca = imeOca;
    }

    public String getMjestoPolaganjaStrucnog() {
        return mjestoPolaganjaStrucnog;
    }

    public void setMjestoPolaganjaStrucnog(String mjestoPolaganjaStrucnog) {
        this.mjestoPolaganjaStrucnog = mjestoPolaganjaStrucnog;
    }

    public String getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(String tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }

    public Integer getJmbg() {
        return jmbg;
    }

    public void setJmbg(Integer jmbg) {
        this.jmbg = jmbg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(String brojLicence) {
        this.brojLicence = brojLicence;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDatumPolaganjaStrucnogIspita() {
        return datumPolaganjaStrucnogIspita;
    }

    public void setDatumPolaganjaStrucnogIspita(LocalDate datumPolaganjaStrucnogIspita) {
        this.datumPolaganjaStrucnogIspita = datumPolaganjaStrucnogIspita;
    }

    public LocalDate getRokVazenjaLicence() {
        return rokVazenjaLicence;
    }

    public void setRokVazenjaLicence(LocalDate rokVazenjaLicence) {
        this.rokVazenjaLicence = rokVazenjaLicence;
    }

    @Override
    public String toString() {
        return "Korisnik: " + ime + " "  + prezime;
    }
}
