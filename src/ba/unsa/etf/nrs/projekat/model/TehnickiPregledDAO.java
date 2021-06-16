package ba.unsa.etf.nrs.projekat.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TehnickiPregledDAO {

    private Connection conn;
    private static TehnickiPregledDAO instance;

    private PreparedStatement sviKorisniciUpit, kreirajKorisnikaUpit, maxIdUpit;
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
            kreirajKorisnikaUpit = conn.prepareStatement("insert into Korisnik(id, ime, prezime, ime_oca, jmbg, datum_polaganja_strucnog_ispita, mjesto_polaganja_strucnog_ispita, broj_licence, datum_roka_vazenja_licence, tip, password, email) values (?,?,?,?,?,?,?,?,?,?,?,?)");
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

    public void addUser(Korisnik korisnik){
        URL url = null;
        JSONObject userObj = new JSONObject();
        userObj.put("date_of_exam", korisnik.getDatumPolaganjaStrucnogIspita());
        userObj.put("place_of_exam", korisnik.getMjestoPolaganjaStrucnog());
        userObj.put("licence", korisnik.getBrojLicence());
        userObj.put("date_of_validity", korisnik.getRokVazenjaLicence());
        userObj.put("type", korisnik.getTipKorisnika());
        userObj.put("name", korisnik.getIme());
        userObj.put("surname", korisnik.getPrezime());
        userObj.put("father", korisnik.getImeOca());
        userObj.put("jmbg", korisnik.getJmbg());
        userObj.put("email", korisnik.getEmail());
        userObj.put("join_date", korisnik.getDatumPocetkaRada());
        try{
            url = new URL("http://tehnicki-pregled.hopto.org/api/v1/users/create");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try{
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGE0NTA4MDU5MzkyODE1ZTY1OGUzZmQiLCJpYXQiOjE2MjM4NTYxOTN9.9FGJIiHajVy0-gHZ1ham8AA0zPrgA8Ek9n3UypaavdQ");
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(userObj.toString());
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Korisnik> getUsers(){
        ArrayList<Korisnik> korisnici = new ArrayList<>();

        try {

            HttpClient client = HttpClient.newHttpClient();

            // Create HTTP request object
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://tehnicki-pregled.hopto.org/api/v1/users/1"))
                    .GET()
                    .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGE0NTA4MDU5MzkyODE1ZTY1OGUzZmQiLCJpYXQiOjE2MjM4NTYxOTN9.9FGJIiHajVy0-gHZ1ham8AA0zPrgA8Ek9n3UypaavdQ")
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
           // System.out.println(response.body());

            JSONObject object = new JSONObject(response.body());

            JSONArray niz = new JSONArray(object.getJSONArray("users"));
            for(int i = 0; i < niz.length(); i++){
                JSONObject jsonObject = niz.getJSONObject(i);
                String proba = jsonObject.getString("date_of_exam");
                String date_of_exam = "";
               String[] pr = proba.split("");
               for(int j = 0; j < 10; j++) {
                   if (j == pr.length - 1) break;
                   date_of_exam += pr[j];
               }

                   String dateOfV = jsonObject.getString("date_of_validity");
                   String date_of_validity = "";
                   String[] dateV = dateOfV.split("");
                   for (int j = 0; j < 10; j++) {
                       if (j == pr.length - 1) break;
                       date_of_validity += dateV[j];

                   }

                String joinDate = jsonObject.getString("join_date");
                String join_date = "";
                String[] dateOfJoin = joinDate.split("");
                for (int j = 0; j < 10; j++) {
                    if (j == pr.length - 1) break;
                    join_date += dateOfJoin[j];

                }

               // System.out.println(date_of_exam);
                Korisnik k = new Korisnik(jsonObject.getString("_id"),jsonObject.getString("name"), jsonObject.getString("surname"), jsonObject.getString("father"), jsonObject.getString("place_of_exam"),
                        jsonObject.getString("email"), jsonObject.getString("licence"), jsonObject.getString("jmbg"), jsonObject.getNumber("type"), LocalDate.parse(date_of_exam),
                        LocalDate.parse(date_of_validity), LocalDate.parse(join_date));
                korisnici.add(k);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return korisnici;


    }
    public ArrayList<TehnickiPregled> getExams(){
        ArrayList<TehnickiPregled> listaTehnickihPregleda = new ArrayList<>();

        try {
            HttpClient client = HttpClient.newHttpClient();

            // Create HTTP request object
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://tehnicki-pregled.hopto.org/api/v1/exams"))
                    .GET()
                    .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGE0NTA4MDU5MzkyODE1ZTY1OGUzZmQiLCJpYXQiOjE2MjM4NTYxOTN9.9FGJIiHajVy0-gHZ1ham8AA0zPrgA8Ek9n3UypaavdQ")
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

           /* URL url = new URL("http://tehnicki-pregled.hopto.org/api/v1/exams");
            BufferedReader ulaz = new BufferedReader(new InputStreamReader(url.openStream(),
                    StandardCharsets.UTF_8));
            String json = "", line = null;
            while ((line = ulaz.readLine()) != null)
                json = json + line;*/
            JSONArray niz = new JSONArray(response.body());
            for(int i = 0; i < niz.length(); i++){

                JSONObject jsonObject = niz.getJSONObject(i);

                String dateCreated = jsonObject.getString("date_created");
                String date_created = "";
                String[] dateOfCreate = dateCreated.split("");
                for (int j = 0; j < 10; j++) {
                    if (j == dateOfCreate.length - 1) break;
                    date_created += dateOfCreate[j];

                }
                TehnickiPregled t = new TehnickiPregled(null, null, jsonObject.getString("_id"),
                        jsonObject.getString("ownership_no"), jsonObject.getString("owner_id"), jsonObject.getString("contact_no"),jsonObject.getString("transaction_id"),
                        jsonObject.getString("chassis_no"), jsonObject.getString("motor_no"), jsonObject.getString("license_plate"), jsonObject.getString("bar_code"),
                        jsonObject.getInt("eta_number"), jsonObject.getInt("engine_power"), jsonObject.getString("color"), jsonObject.getInt("cubic"),
                        jsonObject.getInt("weight"), jsonObject.getString("drive"), jsonObject.getString("fuel_type"), jsonObject.getInt("door_count"),
                        jsonObject.getString("transmission_type"), jsonObject.getString("car_category"), jsonObject.getInt("eco_category"),
                        jsonObject.getInt("seats_no"), jsonObject.getString("manufacturer"), jsonObject.getString("model"), jsonObject.getInt("__v"), LocalDate.parse(date_created));
                listaTehnickihPregleda.add(t);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return listaTehnickihPregleda;
    }

    public void addKorisnik(Korisnik korisnik){
        ResultSet rs = null;
        try {
            rs = maxIdUpit.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

                if(korisnik.getTipKorisnika().equals("Tehničar")) {
                    kreirajKorisnikaUpit.setInt(1, id);
                    kreirajKorisnikaUpit.setString(2, korisnik.getIme());
                    kreirajKorisnikaUpit.setString(3, korisnik.getPrezime());
                    kreirajKorisnikaUpit.setString(4, korisnik.getImeOca());
                    kreirajKorisnikaUpit.setString(5, korisnik.getJmbg());
                    kreirajKorisnikaUpit.setDate(6, Date.valueOf(korisnik.getDatumPolaganjaStrucnogIspita()));
                    kreirajKorisnikaUpit.setString(7, korisnik.getMjestoPolaganjaStrucnog());
                    kreirajKorisnikaUpit.setString(8, korisnik.getBrojLicence());
                    kreirajKorisnikaUpit.setDate(9, Date.valueOf(korisnik.getRokVazenjaLicence()));
                    kreirajKorisnikaUpit.setString(10, "Tehničar");
                    kreirajKorisnikaUpit.setString(11, korisnik.getPassword());
                    kreirajKorisnikaUpit.setString(12, korisnik.getEmail());
                    kreirajKorisnikaUpit.executeUpdate();
                }
                else{
                    kreirajKorisnikaUpit.setInt(1, id);
                    kreirajKorisnikaUpit.setString(2, korisnik.getIme());
                    kreirajKorisnikaUpit.setString(3, korisnik.getPrezime());
                    kreirajKorisnikaUpit.setString(4, korisnik.getImeOca());
                    kreirajKorisnikaUpit.setString(5, korisnik.getJmbg());
                    kreirajKorisnikaUpit.setDate(6, null);
                    kreirajKorisnikaUpit.setString(7, null);
                    kreirajKorisnikaUpit.setInt(8, 0);
                    kreirajKorisnikaUpit.setDate(9, null);
                    kreirajKorisnikaUpit.setString(10, "Administrator");
                    kreirajKorisnikaUpit.setString(11, korisnik.getPassword());
                    kreirajKorisnikaUpit.setString(12, korisnik.getEmail());
                    kreirajKorisnikaUpit.executeUpdate();
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
