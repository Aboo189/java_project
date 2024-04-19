import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class RegularTicket extends Ticket { // this class is in process
    private String eventName;
    private String venue;
    private String date;
    private String row;
    private String price;

    public RegularTicket(String eventName, String venue, String date,String row, String price) {
        this.eventName = eventName;
        this.venue = venue;
        this.date = date;
        this.row = row;
        this.price = price;
    }

    public void putREGintoDB(String eventName, String venue, String date, String row, String price) throws SQLException {
        final String DB_USERNAME = "postgres";
        final String DB_PASSWORD = "Aylin@2016";
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        String sql = "insert into ticket_db (moviename, place, date, row, price, regular, VIP) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, eventName);
        preparedStatement.setString(2, venue);
        preparedStatement.setString(3, date);
        preparedStatement.setString(4, row);
        preparedStatement.setString(5, price);
        preparedStatement.setString(6, "yes");
        preparedStatement.setString(7,"no");
        preparedStatement.executeUpdate();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVenue() { return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) { this.date = date;
    }
    public String getRow() { return row;}
    public void setRow(String row) {
        this.row = row;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void showTicketDetails() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Venue: " + venue);
        System.out.println("Date: " + date);
        System.out.println("Row: " + row);
        System.out.println("Price: " + price);
    }
}
