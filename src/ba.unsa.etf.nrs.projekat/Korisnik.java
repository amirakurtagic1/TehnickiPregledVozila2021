package ba.unsa.etf.nrs.projekat;

import java.util.Date;

public class Korisnik {
    private String ime, prezime, ime_oca, mjesto_polaganje_strucnog, tip_korisnika;
    private Integer jmbg, broj_licence;
    private Date datum_polaganja_strucnog_ispita, rok_vazenja_licence;

    public Korisnik(String ime, String prezime, String ime_oca, String mjesto_polaganje_strucnog, String tip_korisnika, Integer jmbg, Integer broj_licence, Date datum_polaganja_strucnog_ispita, Date rok_vazenja_licence) {
        this.ime = ime;
        this.prezime = prezime;
        this.ime_oca = ime_oca;
        this.mjesto_polaganje_strucnog = mjesto_polaganje_strucnog;
        this.tip_korisnika = tip_korisnika;
        this.jmbg = jmbg;
        this.broj_licence = broj_licence;
        this.datum_polaganja_strucnog_ispita = datum_polaganja_strucnog_ispita;
        this.rok_vazenja_licence = rok_vazenja_licence;
    }

    public Korisnik(String ime, String prezime, String ime_oca, String tip_korisnika, Integer jmbg) {
        this.ime = ime;
        this.prezime = prezime;
        this.ime_oca = ime_oca;
        this.tip_korisnika = tip_korisnika;
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

    public String getIme_oca() {
        return ime_oca;
    }

    public void setIme_oca(String ime_oca) {
        this.ime_oca = ime_oca;
    }

    public String getMjesto_polaganje_strucnog() {
        return mjesto_polaganje_strucnog;
    }

    public void setMjesto_polaganje_strucnog(String mjesto_polaganje_strucnog) {
        this.mjesto_polaganje_strucnog = mjesto_polaganje_strucnog;
    }

    public String getTip_korisnika() {
        return tip_korisnika;
    }

    public void setTip_korisnika(String tip_korisnika) {
        this.tip_korisnika = tip_korisnika;
    }

    public Integer getJmbg() {
        return jmbg;
    }

    public void setJmbg(Integer jmbg) {
        this.jmbg = jmbg;
    }

    public Integer getBroj_licence() {
        return broj_licence;
    }

    public void setBroj_licence(Integer broj_licence) {
        this.broj_licence = broj_licence;
    }

    public Date getDatum_polaganja_strucnog_ispita() {
        return datum_polaganja_strucnog_ispita;
    }

    public void setDatum_polaganja_strucnog_ispita(Date datum_polaganja_strucnog_ispita) {
        this.datum_polaganja_strucnog_ispita = datum_polaganja_strucnog_ispita;
    }

    public Date getRok_vazenja_licence() {
        return rok_vazenja_licence;
    }

    public void setRok_vazenja_licence(Date rok_vazenja_licence) {
        this.rok_vazenja_licence = rok_vazenja_licence;
    }

    @Override
    public String toString() {
        return "Korisnik: " + ime + " "  + prezime;
    }
}
