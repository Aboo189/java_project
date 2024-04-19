import java.sql.*;

public class Booking { //this class is not ready
    private int ticketNum;
    private String ticketType;
    private float price;
    private int numOfTickets;
    private String customerName;
    private String customerEmail;

    // Connection and statement objects for connecting to the database
    private Connection connection;
    private Statement statement;

    // URL, username, and password for connecting to the PostgreSQL database
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ticket_booking_db";
    private static final String DB_USERNAME = "your_username";
    private static final String DB_PASSWORD = "your_password";

    // Constructor for initializing the booking
    public Booking(int ticketNum, String ticketType, float price, int numOfTickets, String customerName, String customerEmail) {
        this.ticketNum = ticketNum;
        this.ticketType = ticketType;
        this.price = price;
        this.numOfTickets = numOfTickets;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    // Method for connecting to the database
    public void connectToDB() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Method for storing the booking in the database
    public void storeBooking() {
        try {
            String sql = "INSERT INTO bookings (ticket_num, ticket_type, price, num_of_tickets, customer_name, customer_email) " +
                    "VALUES (" + ticketNum + ", '" + ticketType + "', " + price + ", " + numOfTickets + ", '" + customerName + "', '" + customerEmail + "')";
            statement.executeUpdate(sql);
            System.out.println("Booking stored in the database.");
        } catch (SQLException e) {
            System.out.println("Error storing the booking in the database: " + e.getMessage());
        }
    }

    // Method for closing the connection to the database
    public void closeConnection() {
        try {
            statement.close();
            connection.close();
            System.out.println("Connection to the database closed.");
        } catch (SQLException e) {
            System.out.println("Error closing the connection to the database: " + e.getMessage());
        }
    }
}
