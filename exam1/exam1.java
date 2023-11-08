package exam1;

/**
 * Class TimeInstant. 
 * This class allows you to represent instants or timestamps with 
 * detail of hours and minutes. Thus, this class represents the moment 
 * that defines a time instant, in this case, the hours and minutes of 
 * any given day.
 * 
 *  @author IIP 
 *  @version Academic Year 2023-24
 */
public class TimeInstant {

    // ATTRIBUTES:
    /** Integer attribute for storing the hours of a TimeInstant. 
     *  It should belong to the iterval <code>[0..23]</code>
     */
    private int hours;
    /** Integer attribute for storing the minutes of a TimeInstant. 
     *  It should belong to the iterval <code>[0..59]</code> 
     */
    private int minutes;
    
    // CONSTRUCTORS:
    /**
     *  Creates a TimeInstant corresponding to iniHours hours and 
     * iniMinutes minutes.
     * Precondition: 0 <= iniHours < 24, 0 <= iniMinutes < 60
     *
     * @param iniHours    Initial value for hours.
     * @param iniMinutes  Initial value for minutes.
     */
    public TimeInstant(int iniHours, int iniMinutes) {
        hours = iniHours;
        minutes = iniMinutes;
    }
    

    /** Returns number of minutes from 00:00 until current TimeInstant object
     *  @return The minutes from 00:00
     */
    public int toMinutes() {
        return hours * 60 + minutes;
    }
   
    /** Returns current TimeInstant object in "hh:mm" format.
     * @return A string representation of the current object.
     */
    public String toString() {
        String hh = "0" + hours;
        hh = hh.substring(hh.length() - 2);
        String mm = "0" + minutes;
        mm = mm.substring(mm.length() - 2);
        return hh + ":" + mm;
    }
   

    /** Updates the hours and minutes of the current TimeInstant (this) 
     *    multiplying them by 2, so that this is still a correct instant, 
     *    i.e. 0 ≤ hours < 24 and 0 ≤ minutes < 60. 
     *  To multiply by 2, the TimeInstant this is passed to minutes and 
     *    these are multiplied by 2. From these minutes, we obtain the 
     *    equivalent hours and minutes with which to update the hours and 
     *    minutes of this. Note that you can get a value for hours ≥ 24.
     *  With the remainder of the division by 24 you will get the correct 
     *    time (whether the value is ≥ 24 or < 24). 
     *  For example, 13:10, multiplying by 2 the hours and minutes, will
     *    become 02:20 (13:10 is equivalent to 790 minutes; multiplying 
     *    by 2 is 1580 minutes, which corresponds to 26 hours and 20 minutes,
     *    2 being the remainder of 26 divided by 24). 07:24 will become 14:48
     *    (07:24 equals 444 minutes; when multiplied by 2, it is 888 minutes, 
     *    which corresponds to 14 hours and 48 minutes, where 14 is the 
     *    remainder of 14 divided by 24). 
     */
    public void multiplyBy2() {
        /* TO COMPLETE */
        
        this.hours = (hours*2)%24;
        this.minutes = minutes*2;
        System.out.print(hours + " " + minutes);
    }
}
