import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Customer {

    private String name;
    private String email;
    private String phone;
    private List<Reservation> reservations;
    private boolean isLoggedIn;
    private String loginID;
    private String password;
    private String address;


    public void Customer(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.reservations = new ArrayList<>();
        this.isLoggedIn = false;
    }

    public void login(String loginID, String password) throws SQLException {
        // check if loginID and password match with the values stored in the database
        // if they match, set isLoggedIn to true
        final String DB_USERNAME = "postgres"; //ur username
        final String DB_PASSWORD = "Aylin@2016"; // password
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_PERSON = "select * from person3 order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_PERSON);
        while (result.next()) {
            String login = result.getString("loginid");
            String pass = result.getString("password");
            if (loginID.equals(login) && password.equals(pass)) {
                System.out.println("You are logged in!");
                isLoggedIn = true;
            }
        }
        if (isLoggedIn == false) {
            System.err.println("ERROR! Try again");
            System.exit(0);
        }
    }

    public void register(String name, String email, String phone, String loginID, String password) throws SQLException {
        final String DB_USERNAME = "postgres"; //ЗДЕСЬ ВСЕ ОКЕЙ
        final String DB_PASSWORD = "Aylin@2016"; // ЗДЕСЬ ВМЕСТО
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres"; // ЗДЕСЬ ВСЕ ОКЕЙ
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        String sql = "insert into person3 (name, email, phone, loginid, password) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, phone);
        preparedStatement.setString(4, loginID);
        preparedStatement.setString(5, password);
        preparedStatement.executeUpdate();
        System.out.println("Cool! You have registered!");
    }

    public void updateuser(String name, String email, String phone,String lastloginID, String lastpassw, String loginID, String password) throws SQLException { // v processe
        final String DB_USERNAME = "postgres";
        final String DB_PASSWORD = "Aylin@2016";
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_PERSON = "select * from person3 order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_PERSON);
        while (result.next()) {
            String login = result.getString("loginid");
            String pass = result.getString("password");
            int id1 = result.getInt("id");
            if (lastloginID.equals(login) && lastpassw.equals(pass)) {
                isLoggedIn = true;
                String updateSql = "UPDATE person3 SET name = ?, email = ?, phone = ?, loginid = ?, password = ? WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, phone);
                    preparedStatement.setString(4, loginID);
                    preparedStatement.setString(5, password);
                    preparedStatement.setInt(6, id1);
                    preparedStatement.executeUpdate();
                }
            }
        }
        if (isLoggedIn == false) {
            System.err.println("ERROR! Invalid LoginID or Password. Try again :/ ");
            System.exit(0);
        }
    }
    public void deleteuser(String loginID, String password) throws SQLException {
        final String DB_USERNAME = "postgres";
        final String DB_PASSWORD = "Aylin@2016";
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_PERSON = "select * from person3 order by id";
        ResultSet result = statement.executeQuery(SQL_SELECT_PERSON);

        while (result.next()) {
            String login = result.getString("loginid");
            String pass = result.getString("password");
            int id1 = result.getInt("id");
            if (loginID.equals(login) && password.equals(pass)) {
                String deleteSql = "delete from person3 WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
                preparedStatement.setInt(1,id1);
                preparedStatement.executeUpdate();
                System.out.println("The User has deleted.");
            }
        }

    }

        public void logout () {
            //code for logout -> isLoggedIn(false)
        }

        public boolean isLoggedIn ( boolean b){
            return isLoggedIn;
        }


        public void makeReservation (Ticket ticket, String paymentMethod){
            Reservation reservation = new Reservation(ticket);
            reservations.add(reservation);
        }

        public List<Reservation> getReservations () {
            return reservations;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getEmail () {
            return email;
        }

        public void setEmail (String email){
            this.email = email;
        }

        public String getPhone () {
            return phone;
        }

        public void setPhone (String phone){
            this.phone = phone;
        }

        public String getAddress () {
            return address;
        }

        public void setAddress (String address){
            this.address = address;
        }

        public String getLoginID () {
            return loginID;
        }
        public void setLoginID (String loginID){
            this.loginID = loginID;
        }

        public String getPassword () {
            return password;
        }
        public void setPassword (String password){
            this.password = password;
        }

    }
