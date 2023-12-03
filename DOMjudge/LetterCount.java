import java.util.*;

public class LetterCount{
    
    static java.util.Scanner in;
    
    static int lines = 0;
    static int digits = 0;
    static int letters = 0;
    
    public static boolean testCase(){
        if(!in.hasNext())
            return false;
        else {
           lines++; 
           String txt = in.nextLine().trim();
           
           for(int i = 0; i < txt.length(); i++){
               if(Character.isLetter(txt.charAt(i))){
                   letters++;
               } else if(Character.isDigit(txt.charAt(i))){
                   digits++;
               }
           }
            
           return true;
        }
    }
    
    public static void main(String[] args){
        
        in = new java.util.Scanner(System.in);
       
        while(testCase()){
        }
       
        System.out.printf("%11d letters\n%11d digits\n%11d lines\n", letters, digits, lines);
        
        
    }
}
