import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        StringBuilder builder = new StringBuilder(); //d - pattern Builder
        builder.append("Welcome to the ");
        builder.append("Ticket ");
        builder.append("Booking System!");
        System.out.println(builder.toString());

        List<String> data = Arrays.asList("Kazakhstan", "Astana"); //d - pattern Strategy
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        Set positionSet = new TreeSet(comparator);
        positionSet.addAll(data);
        System.out.println("Location: " + positionSet);

        System.out.println(Clock.getTime()); //d - pattern Singleton
        Singleton calendar = Singleton.getInstance();
        calendar.SetUp(); //d - pattern Singleton

        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                // Login1
                System.out.println("Enter your loginid: ");
                String loginID = sc.next();
                System.out.println("Enter your password: ");
                String password = sc.next();
                Customer customer = new Customer();
                customer.login(loginID, password);

            }
            case 2 -> {
                // Register
                System.out.println("Enter your name: ");
                String name = sc.next();
                System.out.println("Enter your email: ");
                String email = sc.next();
                System.out.println("Enter your phone number: ");
                String phone = sc.next();
                System.out.println("Enter your loginId: ");
                String loginId = sc.next();
                System.out.println("Enter your password: ");
                String password = sc.next();

                Customer customer = new Customer();
                customer.register(name, email, phone, loginId, password);
            }
            case 3 -> { //to update user
                sc.nextLine();
                System.out.println("Firstly you have to login ");
                System.out.println("Enter your loginID that you want to update: ");
                String lastlogin = sc.nextLine();
                System.out.println("Enter your password: ");
                String lastpassw = sc.nextLine();
                System.out.println("Checking..."); System.out.println("...");
                Customer customer = new Customer();
                customer.login(lastlogin, lastpassw);

                System.out.println("Enter your new name: ");
                String newname = sc.nextLine();
                System.out.println("Enter your new email: ");
                String newemail = sc.nextLine();
                System.out.println("Enter your  new phone: ");
                String newphone = sc.nextLine();
                System.out.println("Enter your new loginID: ");
                String newloginid = sc.nextLine();
                System.out.println("Enter your new password: ");
                String newpassword = sc.nextLine();

                customer.updateuser(newname, newemail, newphone,lastlogin, lastpassw, newloginid, newpassword);

            }
            case 4 -> { // to delete
                System.out.println("Firstly you have to login to get an access");
                System.out.println("Enter your loginID that you want to delete: ");
                sc.nextLine();
                String lastlogin = sc.nextLine();
                System.out.println("Enter your password: ");
                String lastpassw = sc.nextLine();
                System.out.println("Checking..."); System.out.println("...");
                Customer customer = new Customer();
                customer.login(lastlogin, lastpassw);

                System.out.println("Are you sure that you want to delete the user?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int option = sc.nextInt();
                if (option ==1) {
                    customer.deleteuser(lastlogin, lastpassw);
                }
                else if (option == 2) {
                    System.out.println("ok");
                    System.exit(0);
                }
                else {
                    System.err.println("Try again.");
                    System.exit(0);
                }
            }
        }

        System.out.println("1. Book a regular ticket");
        System.out.println("2. Book a VIP ticket");
        int ticketChoice = sc.nextInt();
        if (ticketChoice == 1) {
            // Regular Ticket booking
            System.out.println("Enter the movie name: ");
            String eventName = sc.next();
            System.out.println("Enter the venue: ");
            sc.nextLine();
            String venue = sc.nextLine();
            System.out.println("Enter the date: ");
            String date = sc.nextLine();
            System.out.println("Enter the row: ");
            String row = sc.nextLine();
            System.out.println("Enter the price: ");
            String price = sc.nextLine();
            System.out.println("    ");

            RegularTicket ticket = new RegularTicket(eventName, venue, date, row, price);
            ticket.putREGintoDB(eventName, venue, date, row, price);
            Reservation reservation = new Reservation(ticket);
            ticket.showTicketDetails();
            reservation.bookTicket();
        } else if (ticketChoice == 2) {
            // VIP Ticket booking
            System.out.println("Enter the event name: ");
            String eventName = sc.next();
            System.out.println("Enter the venue: ");
            sc.nextLine();
            String venue = sc.next();
            System.out.println("Enter the date: ");
            sc.nextLine();
            String date = sc.next();
            sc.nextLine();
            System.out.println("Enter the row: ");
            String row = sc.nextLine();
            System.out.println("Enter the price: ");
            String price = sc.nextLine();

            VIPTicket vipTicket = new VIPTicket(eventName, venue, date,row, price);
            vipTicket.putVIPintoDB(eventName, venue, date, row, price);
            Reservation reservation = new Reservation(vipTicket);

            vipTicket.showTicketDetails();
            reservation.bookTicket();
        }
        else {
            System.err.println("Try again.");
            System.exit(0);
        }

        System.out.println("Enter the paymentmethod: ");
        String paymentmethod = sc.nextLine();

    }
}