import java.util.*;

class Example001
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in).useLocale(Locale.US);

    while(input.hasNext()){

      String linea = input.nextLine().trim();

      System.out.println(linea);
    }
  }
}
