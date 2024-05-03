class DailyApptSchedule {
  private Appointment[] apptsForTheDay;
  public static final int NUM_SLOTS = 9;
  public static final String[] TIMES = { "8am", "9am", "10am", "11am",
      "12noon", "1pm", "2pm", "3pm", "4pm" };

  public DailyApptSchedule() {
    apptsForTheDay = new Appointment[NUM_SLOTS];
  }

  /**
   * A method to display the list of appointments for the day
   * In the format:
   * time: appointment_info
   * time: appointment_info ... etc
   * Any empty slots (null Appointments in the array) should be listed as Free
   */
  public void displayAppointments() {
    for (int i = 0; i < NUM_SLOTS; i++) {
      if (apptsForTheDay[i] == null) {
        System.out.println(TIMES[i] + ": Free");
      } else {
        System.out.println(TIMES[i] + ": " + apptsForTheDay[i]);
      }
    }
  }

  /**
   * A method to add the given appointment to the schedule in the specified
   * timeslot
   * 
   * @param whichSlot represents the index of the timeslot (Eg. 0 -> 8am, 1 ->
   *                  9am, ...)
   * @param appt      represents the appointment object
   * @return true if it was successful and false if not successful
   */
  public boolean addAppointment(int whichSlot, Appointment appt) {
    if (whichSlot < 0 || whichSlot >= NUM_SLOTS || apptsForTheDay[whichSlot] != null) {
      return false;
    }
    apptsForTheDay[whichSlot] = appt;
    return true;
  }

  /**
   * A method to add an appointment for the given person, venue and purpose to the
   * schedule in the specified timeslot.
   * 
   * @param whichSlot represents the index of the timeslot (Eg. 0 -> 8am, 1 ->
   *                  9am, ...)
   * @param n         represents the name of the student
   * @param v         represents the location of the appointment
   * @param p         represents the reason for the meeting
   * @return true if it was successful and false if not successful (i.e. if the
   *         given slot is invalid or taken)
   */
  public boolean addAppointment(int whichSlot, String n, String v, String p) {
    if (whichSlot < 0 || whichSlot >= NUM_SLOTS || apptsForTheDay[whichSlot] != null) {
      return false;
    }
    apptsForTheDay[whichSlot] = new Appointment(n, v, p);
    return true;
  }

  public int addAppointment(Appointment appt) {
    for (int i = 0; i < NUM_SLOTS; i++) {
      if (apptsForTheDay[i] == null) {
        apptsForTheDay[i] = appt;
        return i;
      }
    }
    return -1;
  }

  public int addAppointment(String n, String v, String p) {
    for (int i = 0; i < NUM_SLOTS; i++) {
      if (apptsForTheDay[i] == null) {
        apptsForTheDay[i] = new Appointment(n, v, p);
        return i;
      }
    }
    return -1;
  }

  public boolean removeAppointment(int slot) {
    if (slot < 0 || slot >= NUM_SLOTS || apptsForTheDay[slot] == null) {
      return false;
    }
    apptsForTheDay[slot] = null;
    return true;
  }

  public boolean removeAppointment(String n) {
    for (int i = 0; i < NUM_SLOTS; i++) {
      if (apptsForTheDay[i] != null && apptsForTheDay[i].getStudentName().equals(n)) {
        apptsForTheDay[i] = null;
        return true;
      }
    }
    return false;
  }

  // Method header for rescheduling appointment
  public boolean rescheduleAppointment(int oldSlot, int newSlot) {
    if (oldSlot < 0 || oldSlot >= NUM_SLOTS || newSlot < 0 || newSlot >= NUM_SLOTS ||
        apptsForTheDay[oldSlot] == null || apptsForTheDay[newSlot] != null) {
      return false;
    }
    apptsForTheDay[newSlot] = apptsForTheDay[oldSlot];
    apptsForTheDay[oldSlot] = null;
    return true;
  }

}
