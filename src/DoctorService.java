
import java.sql.*;
        import java.util.Scanner;

public class DoctorService {

    public static void addDoctor() {
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DBConnection.getConnection();

            System.out.print("Doctor Name: ");
            String name = sc.nextLine();

            System.out.print("Specialization: ");
            String spec = sc.nextLine();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO doctors(name, specialization) VALUES(?,?)");

            ps.setString(1, name);
            ps.setString(2, spec);
            ps.executeUpdate();

            System.out.println("✅ Doctor added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isDoctorAvailable(int doctorId) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT available FROM doctors WHERE id=?");
            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return rs.getBoolean("available");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
