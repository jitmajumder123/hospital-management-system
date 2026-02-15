
import java.sql.*;
        import java.util.Scanner;

public class PatientService {

    public static void addPatient() {
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DBConnection.getConnection();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Phone: ");
            String phone = sc.nextLine();

            String sql =
                    "INSERT INTO patients(name, age, gender, phone) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, phone);

            ps.executeUpdate();
            System.out.println("✅ Patient registered");

        } catch (Exception e) {
            System.out.println("❌ Error adding patient");
        }
    }

    public static void searchPatientById() {
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM patients WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Phone: " + rs.getString("phone"));
            } else {
                System.out.println("Patient not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
