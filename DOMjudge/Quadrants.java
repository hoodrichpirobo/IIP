import java.util.*;

public class Quadrants {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        
        while(scan.hasNextDouble()){
            double x = scan.nextDouble();
            double y = scan.nextDouble();

//            i think this is pretty straight-forward so i won't tell chatgpt to comment my code lol
            
            System.out.println(allScienceTeachersCrazy(x,y));
        }
        
        
    }
    
    public static String allScienceTeachersCrazy(double x, double y){
            
       if(x == 0 && y == 0){
            return coordinates(x,y) + "at the origin of coordinates";
        }else if(x == 0){
            return coordinates(x,y) + "over the y-axis";
        }else if(y == 0){
            return coordinates(x,y) + "over the x-axis";
        }else if(y > 0){
            return x > 0 ?
                    coordinates(x,y) + "in the first quadrant" :
                    coordinates(x,y) + "in the second quadrant";
        }else{
            return x < 0 ?
                    coordinates(x,y) + "in the third quadrant" :
                    coordinates(x,y) + "in the fourth quadrant";
        }
    }
        
    public static String coordinates(double x, double y){
        return String.format(" ( %.2f, %.2f ) is located ", x, y);
    }
    
}
