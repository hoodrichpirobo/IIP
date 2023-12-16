import java.util.*;

public class JedisI {
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        
        int jedi = 0, sith = 0, borderline = 0;
        String JediTxt = " May the Force be with you!";
        String SithTxt = " Good! Your hate has made you powerful. Now, fulfill your destiny and take your father's place at my side!";
        String BorderlineTxt = " Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering. Suffering leads to the dark side.";
        
        while(scan.hasNextDouble()){
            double x = scan.nextDouble();
            double y = scan.nextDouble();
            double value = a * x + b * y + c;

            if(Math.abs(value) > 1){
                if (value > 0) {
                    jedi++;
                } else {
                    sith++;
                }
            } else {
                borderline++;
            }
        }

        
        System.out.println(assign(jedi, JediTxt));
        System.out.println(assign(borderline, BorderlineTxt));
        System.out.println(assign(sith, SithTxt));
        
    }
    
//    the shitty thing about this problem is having to figure out the formula, i had to look it up online
    
    public static double distanceToHyperplane(double a, double b, double c, double x, double y){
        return Math.abs(a * x + b * y + c) / Math.sqrt(a * a + b * b);
    }
    
    public static String assign(int number, String text){
        return String.format("%7d%s", number, text);
    }
    
}
