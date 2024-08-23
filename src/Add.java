
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Add {
    public void addRecord() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.print("Enter your email: ");
        String email = sc.next();
        System.out.print("Enter your password: ");
        String password = sc.next();
        System.out.print("Enter your gender: ");
        String gender = sc.next();

        Connection con = Main.getCon();
        String sql = "INSERT INTO register VALUES(?,?,?,?) ";

        PreparedStatement ps = Main.getPs(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setString(4, gender);
        int i = ps.executeUpdate();
        if (i > 0) {
            System.out.println("Successfully register");
        } else {
            System.out.println("Failed");
        }
    }
}
