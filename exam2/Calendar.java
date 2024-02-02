package exam2;

import others2.DateTime;
import others2.Event;
import others2.TimeInstant;
import others2.UtilEvent;
/**
 * Clase Calendar: clase tipo de datos que representa el calendario 
 * de un lugar donde se celebran eventos.
 *
 * @author Parcial 2 - Ejercicio 2 
 * @version IIP - Curso 2023/24
 */
public class Calendar {
    public static final int MAX_EVENTS = 30; 
    private int numEvents;
    private Event[] program;
    private int[] numPerType;
    
    /** Crea un Calendar vacío (sin eventos de ningún tipo). */
    public Calendar() {      
        program = new Event[MAX_EVENTS];
        numEvents = 0;
        numPerType = new int[4]; // la posición 0 no se utiliza
    }
     
    /** Devuelve el número actual de eventos.
     *  @return int, el número de eventos.
     */
    public int getNumEvents() { return numEvents; }
    
    /** Devuelve el número de eventos de un tipo type dado, siendo 1 <= type <= 3.
     *  @param type int, el tipo. Precondición: 1 <= type <= 3.
     *  @return int, el número de eventos de tipo type.
     */
    public int getNumType(int type) { return numPerType[type]; }
    
    /** Devuelve la representación como String de todos los eventos del calendario.
     *  @return String.
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < numEvents; i++) {
            res += program[i].toString() + "\n";
        }
        return res;
    }
    
    /** Devuelve true si un Event e dado se solapa con cualquier otro Event 
     *  del calendario. En caso contrario, devuelve false.
     *  @param e Event, el evento.
     *  @return boolean, true si e se solapa y false en caso contrario.
     */
    private boolean overlaps(Event e) {
        boolean exists = false;
        int i = 0;
        while (i < numEvents && !exists) {
            exists = UtilEvent.overlaps(e, program[i]);
            i++;
        }
        return exists;
    }
    
    /** Dado un Event e, si cabe y no se solapa con ningún otro del calendario, lo añade en orden
     *  cronológico y devuelve true. Si no cabe o hay solapamiento, no lo añade y devuelve false.
     *  @param e Event, evento a añadir.  
     *  @return boolean, true si se añade y false en caso contrario.
     */    
    public boolean add(Event e) { 
        if (numEvents == MAX_EVENTS || overlaps(e)) { return false; }
        int i = numEvents - 1; 
        while (i >= 0 && e.getEndTime().compareTo(program[i].getStartTime()) < 0) { 
            program[i + 1] = program[i]; 
            i--;
        }
        program[i + 1] = e;
        numEvents++;
        numPerType[e.getType()]++;
        return true; 
    }

    /** Devuelve la representación como String de todos los eventos del calendario
     *  cuyo instante de finalización sea posterior al TimeInstant t dado. Si no 
     *  hay eventos en dicha situación, devuelve la cadena vacía.
     *  La descripción como String de un evento debe ir separada de la del siguiente 
     *  por una línea en blanco, esto es, debe acabar en salto de línea "\n".
     *  @param t TimeInstant.
     *  @return String.
     */
    public String eventsEndTimeAfter(TimeInstant t) {
        String res = "";
        /* COMPLETAR */
        if(t==null)
        {
            return res;
        }
        for (int i = 0; i < numEvents; i++) {
            if(t.compareTo(program[i].getStartTime())==-1)
            {
                res += program[i].toString() + "\n";
            }
        }
        return res;
    }   
    
}
