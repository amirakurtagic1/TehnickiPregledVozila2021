package ba.unsa.etf.nrs.projekat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class TehnickiPregledDAO {

    private Connection conn;
    private static TehnickiPregledDAO instance;

    private PreparedStatement sviKorisniciUpit;
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



}
