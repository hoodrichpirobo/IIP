import java.util.*;

public class SecondDegreeEquations {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        while(scan.hasNext()){
        
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            double firstSol,secondSol;
            String sol = "", in = a + " " + b + " " + c + "  ";
            double arg = b*b-4*a*c;
            
            if(a == 0 && b == 0 && c == 0){
                sol = "infinite solutions";
            }else if(a==0 && b == 0){
                sol = "undetermined";
            }else if(a==0){
                firstSol = 1.0 * -c/b;
                sol = in + String.format("%.4f", firstSol) + "  first degree equation";
            }else if(arg==0){
                firstSol = 1.0 * -b/(2*a);
                sol = String.format("%.4f", firstSol) + "  double solution";
            }else if(arg<0){
                firstSol = 1.0 * -b/(2*a);
                secondSol = Math.sqrt(-arg)/(2*a);
                sol = String.format("%.4f",firstSol) + " + " + String.format("%.4f", secondSol) +"i  and  " + String.format("%.4f", firstSol) + " - " + String.format("%.4f", secondSol) + "i";
            } else{
                firstSol = 1.0 * (-b+Math.sqrt(arg))/(2*a);
                secondSol = 1.0 * (-b-Math.sqrt(arg))/(2*a);
                sol = String.format("%.4f", firstSol) + "  and  " + String.format("%.4f", secondSol);
            }
            
            System.out.println(sol);
        }   
    }
}
