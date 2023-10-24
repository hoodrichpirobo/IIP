package pract4;

/**
 * Class TimeInstant. 
 * <p> This class allows you to represent instants or timestamps with 
 * detail of hours and minutes. Thus, this class represents the moment 
 * that defines a time instant, in this case, the hours and minutes of 
 * any given day.
 * </p>
 * 
 *  @author Cux Prada  
 *  @version Academic Year 2023-24
 */
public class TimeInstant {

    // ATTRIBUTES:
    /** Integer attribute for storing the hours of a TimeInstant. 
     *  It should belong to the interval <code>[0..23]</code>
     */
    // TO COMPLETE
    
    private int hours;
    
    /** Integer attribute for storing the minutes of a TimeInstant. 
     *  It should belong to the interval <code>[0..59]</code> 
     */
    // TO COMPLETE
        
    private int minutes;
    
    // CONSTRUCTORS:
    /**
     *  <code>TimeInstant</code> corresponding to <code>iniHours</code> 
     *  hours and <code>iniMinutes</code> minutes.
     *  <p> Precondition: <code>0<=iniHours<24, 0<=iniMinutes<60 </code> </p>
     */
     // TO COMPLETE
       
    public TimeInstant(int iniHours, int iniMinutes) {
        minutes = iniMinutes;
        hours = iniHours;
    }
    
    /**
     * <code>TimeInstant</code> (hours and minutes) from current 
     * UTC (universal coordinated time).
     */
    // TO COMPLETE
    
    public TimeInstant() {
        long totalMinutes = System.currentTimeMillis() / (60 * 1000);
        int tMinCurrent = (int) (totalMinutes % (24 * 60));
        hours = tMinCurrent / 60;
        minutes = tMinCurrent % 60;
    }
    
    // CONSULTORS AND MODIFYERS:
    /** Returns hours of current TimeInstant object. */ 
     // TO COMPLETE
    
     public int getHours(){
         return hours;
     }
     
    /** Returns minutes of current TimeInstant object. */ 
     // TO COMPLETE
     
     public int getMinutes(){
         return minutes;
     }
     
    /** Modifies hours of current TimeInstant object. */ 
    // TO COMPLETE
    
    public void setHours(int newHours){
        hours = newHours;
    }
    
    /** Modifies minutes of current TimeInstant object. */ 
     // TO COMPLETE
   
     public void setMinutes(int newMinutes){
         minutes = newMinutes;
     }
     
    // OTHER METHODS:
    /** Returns current TimeInstant object in "hh:mm" format. */
     // TO COMPLETE
     
     public String toString(){
         String hh = "0" + hours;
         hh = hh.substring(hh.length() - 2);
         String mm = "0" + minutes;
         mm = mm.substring(mm.length() - 2);
         return hh + ":" + mm;
     }
   
    /** Returns true only if <code> o </code> is a TimeInstant 
     *  that concides in hours and minutes with current TimeInstant.
     */
     // TO COMPLETE
     
     public boolean equals(Object o){
         return o instanceof TimeInstant
             && ((TimeInstant) o).hours == this.hours
             && ((TimeInstant) o).minutes == this.minutes;
     }
      
    /** Returns number of minutes from 
     *  00:00 until current TimeInstant object
     */
     // TO COMPLETE
     
     public int toMinutes(){
         return this.hours * 60 + this.minutes;
     }
    
    /** Chronological comparison of current TimeInstant object 
     *  and <code>tInstant</code> parameter. Result is:
     *     <ul>
     *      <li>negative when current TimeInstant is previous to 
     *        <code>tInstant</code>
     *      </li>
     *      <li> zero if they are equal
     *      </li>
     *      <li>positive when current TimeInstant is posterior to 
     *        <code>tInstant</code>
     *      </li>
     *    </ul>
     */
      // TO COMPLETE
      
      public int compareTo(TimeInstant tInstant) {
        // comparing hours first
        if (this.hours < tInstant.hours) return -1;
        if (this.hours > tInstant.hours) return 1;
        // if hours are same, then compare minutes
        if (this.minutes < tInstant.minutes) return -1;
        if (this.minutes > tInstant.minutes) return 1;
        // if both hours and minutes are same
        return 0;
    }
      

    // EXTRA ACTIVITY:
    /** Returns a TimeInstant from its textual description 
     *  in a <code>String</code> with format "<code>hh:mm</code>".
     */
      // TO COMPLETE
      
      public static TimeInstant valueOf(String textInstant) {
        // extract hours and minutes from the string
        int hourTens = textInstant.charAt(0) - '0';
        int hourUnits = textInstant.charAt(1) - '0';
        int minuteTens = textInstant.charAt(3) - '0';
        int minuteUnits = textInstant.charAt(4) - '0';

        // compute hours and minutes
        int hours = hourTens * 10 + hourUnits;
        int minutes = minuteTens * 10 + minuteUnits;

        // return new TimeInstant object
        return new TimeInstant(hours, minutes);
    }
  
}
