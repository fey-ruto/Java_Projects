class WeeklyApptSchedule {

   private DailyApptSchedule[] apptsForTheWeek;

   public static final int NUM_DAYS = 5;
   public static final String[] DAYS = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

   public WeeklyApptSchedule() {
      apptsForTheWeek = new DailyApptSchedule[NUM_DAYS];
      for (int i = 0; i < NUM_DAYS; i++) {
         apptsForTheWeek[i] = new DailyApptSchedule();
      }
   }

   // display weekly appointments
   // Display the set of appointments for the week by showing
   // the schedule for each day.
   public void displayWeeklyAppointments() {
      for (int i = 0; i < NUM_DAYS; i++) {
         System.out.println(DAYS[i] + ":");
         apptsForTheWeek[i].displayAppointments();
      }
   }

   // Add an appointment for a given timeslot on a given day.
   // Note: You may find it helpful to invoke day.ordinal()
   // ordinal() is a method automatically defined for enumerations
   // it gives an "index" of a particular value in the enumeration.
   public boolean addAppointment(Appointment appt, String day, String timeSlot) {
      int dayIndex = getDayIndex(day); // Convert day string to index
      if (dayIndex == -1) {
         System.out.println("Invalid day!");
         return false;
      }
      int timeSlotIndex = getTimeSlotIndex(timeSlot); // Convert timeSlot string to index
      if (timeSlotIndex == -1) {
         System.out.println("Invalid time slot!");
         return false;
      }
      return apptsForTheWeek[dayIndex].addAppointment(timeSlotIndex, appt);
   }

   // Corrected cancelAppointment method
   public void cancelAppointment(String day, String timeSlot) {
      int dayIndex = getDayIndex(day); // Convert day string to index
      if (dayIndex == -1) {
         System.out.println("Invalid day!");
         return;
      }
      int timeSlotIndex = getTimeSlotIndex(timeSlot); // Convert timeSlot string to index
      if (timeSlotIndex == -1) {
         System.out.println("Invalid time slot!");
         return;
      }
      apptsForTheWeek[dayIndex].removeAppointment(timeSlotIndex);
   }

   // Helper method to get the index of the day
   private int getDayIndex(String day) {
      for (int i = 0; i < DAYS.length; i++) {
         if (DAYS[i].equalsIgnoreCase(day)) {
            return i;
         }
      }
      return -1; // Day not found
   }

   // Helper method to get the index of the time slot
   private int getTimeSlotIndex(String timeSlot) {
      for (int i = 0; i < DailyApptSchedule.TIMES.length; i++) {
         if (DailyApptSchedule.TIMES[i].equalsIgnoreCase(timeSlot)) {
            return i;
         }
      }
      return -1; // Time slot not found
   }

   public boolean rescheduleAppointment(String day, String oldTimeSlot, String newTimeSlot) {
      int dayIndex = getDayIndex(day);
      if (dayIndex == -1) {
         System.out.println("Invalid day!");
         return false;
      }

      int oldTimeSlotIndex = getTimeSlotIndex(oldTimeSlot);
      if (oldTimeSlotIndex == -1) {
         System.out.println("Invalid old time slot!");
         return false;
      }

      int newTimeSlotIndex = getTimeSlotIndex(newTimeSlot);
      if (newTimeSlotIndex == -1) {
         System.out.println("Invalid new time slot!");
         return false;
      }

      return apptsForTheWeek[dayIndex].rescheduleAppointment(oldTimeSlotIndex, newTimeSlotIndex);
   }
}