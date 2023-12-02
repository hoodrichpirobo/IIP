import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        int wordCount = 0;
        int lineCount = 0;
        
        while(scan.hasNext()){
            String line = scan.nextLine().trim();
            if(!line.isEmpty()) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            lineCount++;
            
        }
       
        System.out.printf("%11d words\n", wordCount);
        System.out.printf("%11d lines\n", lineCount);

        scan.close();
    }
}
