package exam2;

/**
 * Clase IIPMath: clase de utilidades que implementa
 * algunas operaciones matematicas.
 * 
 * @author Parcial 2 - Ejercicio 1 
 * @version IIP - Curso 2023/24
 */
public class IIPMath {
    /** No se pueden crear objetos de este tipo. */
    private IIPMath() { }
    
    /** Devuelve la suma de los terminos de la serie:
     *     a_1 = 2 
     *     a_i = a_(i-1) + 5 * i, i > 1
     *  hasta que el ultimo termino sumado sea mayor 
     *  o igual que value.
     *  PRECONDICION: 0 < value
     */  
    public static int sumTerms(int value) { 
        int term = 2;    // ultimo termino calculado
        int i = 1;       // indice del ultimo termino calculado        
        int suma = term; // suma de los terminos calculados
        int sum = term;
        
        /* COMPLETAR con un bucle */
        
        while(suma<value)
        {
            i++;
            suma = term + 5*i;
            term = suma;
            sum += suma;
        }
        
        return sum; 
    }
}