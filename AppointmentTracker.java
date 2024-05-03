import java.util.Scanner;

public class AppointmentTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeeklyApptSchedule weeklySchedule = new WeeklyApptSchedule();

        while (true) {
            System.out.println("\n=== Appointment Management System ===");
            System.out.println("1. Book an appointment");
            System.out.println("2. Cancel an appointment");
            System.out.println("3. Reschedule an appointment");
            System.out.println("4. Display appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Book an appointment
                    System.out.println("\n=== Book an Appointment ===");
                    System.out.print("Kindly enter day (Monday, Tuesday, ...): ");
                    String bookDay = scanner.next();
                    System.out.print("Kindly enter timeslot (8am, 9am, ...): ");
                    String bookTimeSlot = scanner.next();
                    System.out.print("Kindly enter student name: ");
                    String studentName = scanner.next();
                    System.out.print("Kindly enter venue: ");
                    String venue = scanner.next();
                    System.out.print("Kindly enter purpose: ");
                    String purpose = scanner.next();
                    Appointment newAppointment = new Appointment(studentName, venue, purpose);
                    weeklySchedule.addAppointment(newAppointment, bookDay, bookTimeSlot);
                    break;
                case 2:
                    // Cancel an appointment
                    System.out.println("\n=== Cancel an Appointment ===");
                    System.out.print("Kindly enter day (Monday, Tuesday, ...): ");
                    String cancelDay = scanner.next();
                    System.out.print("Kindly enter timeslot (8am, 9am, ...): ");
                    String cancelTimeSlot = scanner.next();
                    weeklySchedule.cancelAppointment(cancelDay, cancelTimeSlot);
                    break;
                case 3:
                    // Reschedule an appointment
                    System.out.println("\n=== Reschedule an Appointment ===");
                    System.out.print("Kindly enter day (Monday, Tuesday, ...): ");
                    String rescheduleDay = scanner.next();
                    System.out.print("Kindly enter current timeslot (8am, 9am, ...): ");
                    String rescheduleOldTimeSlot = scanner.next();
                    System.out.print("Kindly enter new timeslot (8am, 9am, ...): ");
                    String rescheduleNewTimeSlot = scanner.next();
                    weeklySchedule.rescheduleAppointment(rescheduleDay, rescheduleOldTimeSlot, rescheduleNewTimeSlot);
                    break;
                case 4:
                    // Display appointments
                    weeklySchedule.displayWeeklyAppointments();
                    break;
                case 5:
                    // Exit
                    System.out.println(" Now Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
