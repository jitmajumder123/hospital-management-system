
import java.sql.*;
        import java.util.Scanner;

public class AppointmentService {

    public static void bookAppointment() {
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DBConnection.getConnection();

            System.out.print("Patient ID: ");
            int pid = sc.nextInt();

            System.out.print("Doctor ID: ");
            int did = sc.nextInt();
            sc.nextLine();

            if (!DoctorService.isDoctorAvailable(did)) {
                System.out.println("Doctor not available");
                return;
            }

            System.out.print("Date (YYYY-MM-DD): ");
            String date = sc.nextLine();

            String sql =
                    "INSERT INTO appointments(patient_id, doctor_id, date) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setInt(2, did);
            ps.setString(3, date);

            ps.executeUpdate();
            System.out.println("✅ Appointment booked");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("❌ Appointment already exists");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
