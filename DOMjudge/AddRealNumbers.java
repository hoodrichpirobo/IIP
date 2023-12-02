import java.util.*;

class AddRealNumbers {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        while(scan.hasNext()){
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            
            double sum = a + b;
            
            System.out.println(String.format("%.3f", a) + " + " + String.format("%.3f", b) + " = " + String.format("%.3f", sum));
            
        }
    }
    
}
