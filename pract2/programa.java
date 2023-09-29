package pract2;


/**
 * My attempt at a program that will draw a beautiful world.
 * 
 * @author (Dani) 
 * @version (0.1)
 */
public class programa{
 private programa() { }
 
 public static void main(String[] args) {
     // Inicializar el lugar de dibujo, dándole
        // un nombre y dimensiones:
        Blackboard miPizarra = new Blackboard("UNA VENTANA AL MUNDO", 1000, 1000);
        
        // Inicializar un círculo amarillo:
        Circle c = new Circle(30, "black", 100, 100);
        
        // ponerlo en el espacio de dibujo:
        miPizarra.add(c);
        
        // mostrar por pantalla el perímetro del círculo:
        System.out.println("El perímetro del círculo es " + c.perimeter() /*COMPLETAR*/);
        
        // Inicializar un triángulo isósceles negro:
        TrIsosceles t = new TrIsosceles(100, 130, "black", 100, 200 );
        // ponerlo en el espacio de dibujo:
         miPizarra.add(t);
        }
}
