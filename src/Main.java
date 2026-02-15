import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Add Doctor");
            System.out.println("4. Book Appointment");
            System.out.println("5. Exit");

            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> PatientService.addPatient();
                case 2 -> PatientService.searchPatientById();
                case 3 -> DoctorService.addDoctor();
                case 4 -> AppointmentService.bookAppointment();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
