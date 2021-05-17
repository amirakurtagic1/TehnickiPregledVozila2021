package ba.unsa.etf.nrs.projekat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class TehnickiPregledDAO {

    private Connection conn;
    private static TehnickiPregledDAO instance;

    private PreparedStatement sviKorisniciUpit, kreirajAdministratoraUpit, maxIdUpit;
    public static TehnickiPregledDAO getInstance() {
        if (instance == null) instance = new TehnickiPregledDAO();
        return instance;
    }


    private TehnickiPregledDAO(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:tpv.db");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            sviKorisniciUpit = conn.prepareStatement("SELECT * FROM Korisnik");
        } catch (SQLException e) {
            regenerisiBazu();
            try {
                sviKorisniciUpit = conn.prepareStatement("SELECT * FROM Korisnik");
                } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        try{
            kreirajAdministratoraUpit = conn.prepareStatement("insert into Korisnik(id, ime, prezime, ime_oca, jmbg, datum_polaganja_strucnog_ispita, mjesto_polaganja_strucnog_ispita, broj_licence, datum_roka_vazenja_licence, tip) values (?,?,?,?,?,?,?,?,?,?)");
            maxIdUpit = conn.prepareStatement("select MAX(id)+1 from Korisnik");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public static void removeInstance() {
        if (instance == null) return;
        instance.close();
        instance = null;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("Korisnik.sql"));
            String sqlUpit = "";
            while (ulaz.hasNext()) {
                sqlUpit += ulaz.nextLine();
                if ( sqlUpit.length() > 1 && sqlUpit.charAt( sqlUpit.length()-1 ) == ';') {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void addKorisnik(Korisnik korisnik){
        ResultSet rs = null;
        try {
            rs = maxIdUpit.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            kreirajAdministratoraUpit.setInt(1, id);
            kreirajAdministratoraUpit.setString(2, korisnik.getIme());
            kreirajAdministratoraUpit.setString(3, korisnik.getPrezime());
            kreirajAdministratoraUpit.setString(4, korisnik.getImeOca());
            kreirajAdministratoraUpit.setInt(5, korisnik.getJmbg());
            kreirajAdministratoraUpit.setDate(6, Date.valueOf(korisnik.getDatumPolaganjaStrucnogIspita()));
            kreirajAdministratoraUpit.setString(7, korisnik.getMjestoPolaganjaStrucnog());
            kreirajAdministratoraUpit.setInt(8, korisnik.getBrojLicence());
            kreirajAdministratoraUpit.setDate(9, Date.valueOf(korisnik.getRokVazenjaLicence()));
            kreirajAdministratoraUpit.setString(10, korisnik.getTipKorisnika());
            kreirajAdministratoraUpit.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
