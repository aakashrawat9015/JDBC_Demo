import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {


        static Connection con;
        static PreparedStatement ps;

        static {
            try {
                String url = System.getenv("db_url");
                String user = System.getenv("db_username");
                String password = System.getenv("db_password");
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        public static Connection getCon () {
            return con;
        }

        public static PreparedStatement getPs (String sql_query) throws SQLException {
            PreparedStatement ps = con.prepareStatement(sql_query);
            return ps;
        }

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int in = 0;

// make objects
        Add add_data = new Add();
        Update update = new Update();
        while (choice != 4) {
            System.out.println("1. Add data into database Press 1 ");
            System.out.println("2. Update data into database Press 2");
            System.out.println("3. Delete data into database Press 3");
            System.out.println("4. Exit Press 4 ");
            in = sc.nextInt();

            switch (in) {
                case 1:
                    add_data.addRecord();
                    break;

                case 2:
                    update.updateRecord();
                    break;

                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("not valid choice");

            }
        }
    }
}