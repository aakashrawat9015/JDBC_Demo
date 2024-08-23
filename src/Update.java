import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    public void updateRecord() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String email = "abbu123mail.com";
        System.out.println("If you want to update the data type Y(yes) and N(no) ");
        String Y = "y";
        String input = sc.next().toLowerCase();
        if (input.equals(Y)) {
            System.out.print("Ener the new name for updation: ");
            String new_name = sc.next();
            Connection con = Main.getCon();
            String sql = "UPDATE register SET name=? WHERE email=?";

            PreparedStatement ps = Main.getPs(sql);
            ps.setString(1, new_name);
            ps.setString(2,email);

            int j= ps.executeUpdate();
            if(j>0){
                System.out.println("succesful");
            }
            else{
                System.out.println("failed");
            }
        }
    }
}
