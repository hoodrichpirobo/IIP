package pract7;

import pract5.DateTime;

/**
 * Calendar class: data type class representing the calendar of a venue where events are held.
 *
 * @version Academic Year 2023/24
 */
public class Calendar {
    private Event[] program; // Array to store events
    private int numEvents;   // Number of events currently in the calendar
    private static final int MAX_EVENTS = 100; // Maximum number of events the calendar can hold
    
    /** Default constructor to create a new Calendar object empty (without events). */
    public Calendar() {
        program = new Event[MAX_EVENTS];
        numEvents = 0;
    }
    
    /** 
     * Getter Method of the instance attribute numEvents. Return the total number of events.
     * @return int, the number of events.
     */
    public int getNumEvents() {
        return numEvents;
    }
    
    /** 
     * Getter Method of the number of events of a given type, where 1 <= type <= 3.
     * @param type int, the type. Precondition: 1 <= type <= 3.
     * @return int, the number of events of this type.
     */
    public int getNumType(int type) {
        int count = 0;
        for (int i = 0; i < numEvents; i++) {
            if (program[i].getType() == type) {
                count++;
            }
        }
        return count;
    }
    
    /** 
     * Method toString, returns the String representation of all the events of the calendar.
     * @return String.
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numEvents; i++) {
            res.append(program[i].toString()).append("\n");
        }
        return res.toString();
    }
    
    /** 
     * Method that returns true if a given Event e overlaps with any other Event 
     * in the current calendar. Otherwise, it returns false.
     * @param e Event, the event.
     * @return boolean, true if e overlaps and false otherwise.
     */
    private boolean overlaps(Event e) {
        for (int i = 0; i < numEvents; i++) {
            // Assuming getStartTime and getEndTime return DateTime objects
            DateTime start1 = program[i].getStartTime();
            DateTime end1 = program[i].getEndTime();
            DateTime start2 = e.getStartTime();
            DateTime end2 = e.getEndTime();
    
            // Check if e starts before event i ends and ends after event i starts
            if ((start1.compareTo(start2) <= 0 && end1.compareTo(start2) > 0) || 
                (start2.compareTo(start1) <= 0 && end2.compareTo(start1) > 0)) {
                return true;
            }
        }
        return false;
    }

    
    /** 
     * Method that, if a given Event e fits and does not overlap with any other
     * in the current calendar, adds it in chronological order to the calendar and returns true. 
     * If it does not fit or there is overlap, it does not add it and returns false.
     * @param e Event, event to be added.  
     * @return boolean, true if added and false otherwise.
     */    
    public boolean add(Event e) { 
        if (numEvents < MAX_EVENTS && !overlaps(e)) {
            program[numEvents++] = e;
            // You might want to sort the events after adding a new one if they need to be in chronological order
            // Arrays.sort(program, 0, numEvents, Comparator.comparing(Event::getDateTime));
            return true; 
        }
        return false;
    }
    
    /** 
     * Method that returns the position in the array program for a given title event.
     * or -1 if it does not exist.
     * @param title String, the title.
     * @return int, the position of the event in the array or -1 if not present. 
     */
    private int searchTitle(String title) {
        for (int i = 0; i < numEvents; i++) {
            if (program[i].getTitle().equals(title)) {
                return i;
            }
        }
        return -1;  
    }
           
    /** 
     * Method that removes the given title event from the calendar, if it exists, and returns true.
     * If it does not exist, removes nothing and returns false.
     * @param title String, the title.
     * @return boolean, true if removed and false otherwise.
     */
    public boolean delete(String title) {
        int pos = searchTitle(title);
        if (pos != -1) {
            // Shift the remaining elements to the left
            System.arraycopy(program, pos + 1, program, pos, numEvents - pos - 1);
            numEvents--;
            return true;
        }
        return false;
    }
    
    /** 
     * Method that returns the longest event (with the longest duration) in the calendar.
     * Precondition: at least one event.
     * @return Event, the event.
     */
    public Event eventLarger() {
        if (numEvents == 0) return null;
        Event longestEvent = program[0];
        for (int i = 1; i < numEvents; i++) {
            if (program[i].getDuration() > longestEvent.getDuration()) {
                longestEvent = program[i];
            }
        }
        return longestEvent;
    }
    
    /** 
     * Method that returns an array with all the events of type type of the calendar, being 1 <= type <= 3. 
     * The size of the returned array must be equal to the number of events of type type, 
     * being 0 if there are no events of type type.
     * @param type int, the type. Precondition: 1 <= type <= 3.
     * @return Event[], the array.
     */
    public Event[] filterByType(int type) {
        int count = getNumType(type);
        if (count == 0) return new Event[0];
        
        Event[] filteredEvents = new Event[count];
        int index = 0;
        for (int i = 0; i < numEvents && index < count; i++) {
            if (program[i].getType() == type) {
                filteredEvents[index++] = program[i];
            }
        }
        return filteredEvents;
    }
}
