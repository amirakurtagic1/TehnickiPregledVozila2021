package ba.unsa.etf.nrs.projekat.model;

import java.time.LocalDate;
import java.util.Date;

public class Korisnik {
    private String ime, prezime, imeOca, mjestoPolaganjaStrucnog, email, brojLicence, password;
    private String jmbg;
    private Number tipKorisnika;
    private String id;
    private LocalDate datumPolaganjaStrucnogIspita, rokVazenjaLicence, datumPocetkaRada;

    public Korisnik(String id, String ime, String prezime, String imeOca, String mjestoPolaganjaStrucnog, String email, String brojLicence, String password, String jmbg, Number tipKorisnika, LocalDate datumPolaganjaStrucnogIspita, LocalDate rokVazenjaLicence, LocalDate datumPocetkaRada) {
       this.id  = id;
        this.ime = ime;
        this.prezime = prezime;
        this.imeOca = imeOca;
        this.mjestoPolaganjaStrucnog = mjestoPolaganjaStrucnog;
        this.email = email;
        this.brojLicence = brojLicence;
        this.password = password;
        this.jmbg = jmbg;
        this.tipKorisnika = tipKorisnika;
        this.datumPolaganjaStrucnogIspita = datumPolaganjaStrucnogIspita;
        this.rokVazenjaLicence = rokVazenjaLicence;
        this.datumPocetkaRada = datumPocetkaRada;
    }
    public Korisnik(String id, String ime, String prezime, String imeOca, String mjestoPolaganjaStrucnog, String email, String brojLicence, String jmbg, Number tipKorisnika, LocalDate datumPolaganjaStrucnogIspita, LocalDate rokVazenjaLicence, LocalDate datumPocetkaRada) {
        this.id = id;
        this.ime = ime;
       this.prezime = prezime;
        this.imeOca = imeOca;
        this.mjestoPolaganjaStrucnog = mjestoPolaganjaStrucnog;
        this.email = email;
        this.brojLicence = brojLicence;
        this.jmbg = jmbg;
        this.tipKorisnika = tipKorisnika;
        this.datumPolaganjaStrucnogIspita = datumPolaganjaStrucnogIspita;
        this.rokVazenjaLicence = rokVazenjaLicence;
        this.datumPocetkaRada = datumPocetkaRada;
    }

    public Korisnik(String ime, String prezime, String imeOca, String mjestoPolaganjaStrucnog, String email, String brojLicence, String jmbg, Number tipKorisnika, LocalDate datumPolaganjaStrucnogIspita, LocalDate rokVazenjaLicence, LocalDate datumPocetkaRada) {
        this.ime = ime;
        this.prezime = prezime;
        this.imeOca = imeOca;
        this.mjestoPolaganjaStrucnog = mjestoPolaganjaStrucnog;
        this.email = email;
        this.brojLicence = brojLicence;
        this.jmbg = jmbg;
        this.tipKorisnika = tipKorisnika;
        this.datumPolaganjaStrucnogIspita = datumPolaganjaStrucnogIspita;
        this.rokVazenjaLicence = rokVazenjaLicence;
        this.datumPocetkaRada = datumPocetkaRada;
    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Number getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(Number tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }

    public LocalDate getDatumPocetkaRada() {
        return datumPocetkaRada;
    }

    public void setDatumPocetkaRada(LocalDate datumPocetkaRada) {
        this.datumPocetkaRada = datumPocetkaRada;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
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
