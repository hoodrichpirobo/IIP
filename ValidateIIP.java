import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateIIP {
   private static final int CAS = 1;
   private static final int VAL = 2;
   private static final int ENG = 3;
   private static final String OS = System.getProperty("os.name");
   private static final String SEP;
   private static final File PATH;
   private static final String RAIZ;
   private static final String DISCOWIIP = "iip";
   private static final String LIBS;
   private static final String LIB_GRAFICA = "graphLib.jar";
   private static final boolean LIBR;
   private static int[][] practPorParcial;
   private static String[][] ficheros;
   private static String[] textos;
   private static int cont;

   private ValidateIIP() {
   }

   private static void setLanguage(int lan) {
      ficheros = new String[][]{{"pract2", "Circle", "TestProgram", "Rectangle", "TrIsosceles", "Blackboard"}, {"pract3", "Test3"}, {"pract4", "TimeInstant", "Test4"}, {"pract5", "DateTime", "Test5"}, {"pract6", "IIPMath", "TestIIPMath"}, {"pract7", "UtilEvent", "Event", "Calendar", "Test7"}};
      switch (lan) {
         case 1:
            textos = new String[]{"El directorio", "existe ", "Pr\u00e1ctica 2", "Pr\u00e1ctica 3", "Pr\u00e1ctica 4", "Pr\u00e1ctica 5", "Pr\u00e1ctica 6", "Pr\u00e1ctica 7", "Pr\u00e1cticas 5, 6 y 7", "Pr\u00e1cticas 2, 3 y 4", "un paquete", "un proyecto", "El archivo", "Terminar", "    Elige una opci\u00f3n ", "Int\u00e9ntalo de nuevo...", "\u00a1Aseg\u00farate de introducir un entero v\u00e1lido! ", "Fin.", "El archivo graphLib.jar encontrado en el CLASSPATH:      OK", "El archivo graphLib.jar NO encontrado en el CLASSPATH:  ERROR", "\u00bfQu\u00e9 parcial quieres validar (1 - 2)? ", "no existe ", "y es ", "y no es ", "\n ------------------", "\n\tPuede que algunos ficheros no est\u00e9n, o que no est\u00e9n compilados,\n\to que su nombre no coincida con el que se indica en el enunciado\n\tde la pr\u00e1ctica.", "(0 - 4): ", "(0 - 4): "};
            break;
         case 2:
            textos = new String[]{"El directori", "existeix ", "Pr\u00e0ctica 2", "Pr\u00e0ctica 3", "Pr\u00e0ctica 4", "Pr\u00e0ctica 5", "Pr\u00e0ctica 6", "Pr\u00e0ctica 7", "Pr\u00e0ctiques 5, 6 i 7", "Pr\u00e0ctiques 2, 3 i 4", "un paquet", "un projecte", "L'arxiu", "Acabar", "    Tria una opci\u00f3 ", "Intenta-ho una altra vegada...", "Assegura't d'introduir un enter v\u00e0lid! ", "Fi.", "L'arxiu graphLib.jar es troba en el CLASSPATH:         OK", "L'arxiu graphLib.jar NO es troba en el CLASSPATH:      ERROR", "Quin parcial vols validar (1 - 2)? ", "no existeix ", "i \u00e9s ", "i no \u00e9s ", "\n ------------------", "\n\tPot ser que alguns fitxers no estiguen, o que no estiguen compilats,\n\to que el seu nom no coincidisca amb el que s'indica en l'enunciat \n\tde la pr\u00e0ctica.", "(0 - 4): ", "(0 - 4): "};
            break;
         case 3:
            textos = new String[]{"Directory", "exists ", "Lab activity 2", "Lab activity 3", "Lab activity 4", "Lab activity 5", "Lab activity 6", "Lab activity 7", "Lab activities 5, 6 and 7", "Lab activities 2, 3 and 4", "a package", "a project", "File", "Finish", "    Choose and option ", "Try it again...", "Be sure to input a valid integer! ", "End.", "File graphLib.jar found at the CLASSPATH:              OK", "File graphLib.jar can't be found at the CLASSPATH:     ERROR", "What semester do you want to validate (1 - 2)? ", "doesn't exist ", "and it is ", "and it isn't ", "\n ------------------", "\n\tIt is possible that some files are not present, or not compiled, \n\tor with a different name to that presented in the lab report.", "(0 - 4): ", "(0 - 4): "};
      }

   }

   private static void verificarDirLibs(boolean verb) {
      if (verb) {
         File f = new File(LIBS);
         boolean existeLIBS = false;
         existeLIBS = f.exists() && f.isDirectory();
         System.out.printf("\n\t%-13s %-40s %-5s\n", textos[0], "iip" + SEP + "+libs", existeLIBS ? textos[1] : textos[21]);
      }

   }

   private static void verificarLibrerias(boolean verb) {
      if (verb) {
         File f = new File(LIBS);
         boolean existeLIBS = false;
         existeLIBS = f.exists() && f.isDirectory();
         System.out.printf("\n\t%-13s %-40s %-5s", textos[0], "iip" + SEP + "+libs", existeLIBS ? textos[1] : textos[21]);
         String var10001 = LIBR ? textos[18] : textos[19];
         System.out.println("\n\t" + var10001);
      }

   }

   private static int menu(Scanner tec, int parcial) {
      String op1 = textos[8];
      String op2 = textos[5];
      String op3 = textos[6];
      String op4 = textos[7];
      String op5 = "";
      String op6 = textos[27];
      int last = 4;
      if (parcial == 1) {
         op1 = textos[9];
         op2 = textos[2];
         op3 = textos[3];
         op4 = textos[4];
         op5 = "";
         op6 = textos[26];
         last = 4;
      }

      System.out.println("\n\n------------- MENU --------------");
      System.out.println(" 0) " + textos[13]);
      System.out.println(" 1) " + op1);
      System.out.println(" 2) " + op2);
      System.out.println(" 3) " + op3);
      System.out.println(" 4) " + op4);
      System.out.println("---------------------------------");
      int opcion = leerInt(tec, textos[14] + op6, 0, last);
      return opcion;
   }

   private static int leerInt(Scanner tec, String mensaje, int lInferior, int lSuperior) {
      int res = 0;
      boolean hayError = true;
      String text1 = "\u00a1Aseg\u00farate de introducir un entero v\u00e1lido! Int\u00e9ntalo de nuevo...\n";
      String text2 = "Assegura't d'introduir un enter v\u00e0lid! Intenta-ho una altra vegada...\n";
      String text3 = "Be sure to input a valid integer! Try it again...";
      String text0 = text1 + text2 + text3;

      do {
         try {
            System.out.print(mensaje);
            res = tec.nextInt();
            if (res <= lSuperior && res >= lInferior) {
               hayError = false;
            } else {
               System.out.println(cont == 0 ? text0 : textos[16] + textos[15]);
            }
         } catch (InputMismatchException var14) {
            System.out.println(cont == 0 ? text0 : textos[16] + textos[15]);
         } finally {
            tec.nextLine();
         }
      } while(hayError);

      ++cont;
      return res;
   }

   private static boolean validarProyectoIIP(boolean verb) {
      File f = new File(RAIZ);
      boolean existeIIP = false;
      boolean esProyIIP = false;
      existeIIP = f.exists() && f.isDirectory();
      if (existeIIP) {
         esProyIIP = (new File(RAIZ + SEP + "package.bluej")).exists();
      }

      if (verb) {
         System.out.printf("\n\t%-13s %-40s %-5s", textos[0], "iip", existeIIP ? textos[1] : textos[21]);
         if (existeIIP) {
            String var10001 = esProyIIP ? textos[22] : textos[23];
            System.out.print(var10001 + textos[11]);
         }

         System.out.println(textos[24]);
      }

      return existeIIP && esProyIIP;
   }

   private static boolean validarPractica(int p, boolean verb) {
      boolean respuesta = true;
      boolean existeNom = false;
      boolean esPackNom = false;
      boolean existeJ = false;
      boolean existeC = false;
      String nomPCorto = "iip" + SEP + ficheros[p][0];
      String nom = RAIZ + SEP + ficheros[p][0];
      File f = new File(nom);
      existeNom = f.exists() && f.isDirectory();
      if (existeNom) {
         esPackNom = (new File(nom + SEP + "package.bluej")).exists();
      }

      if (verb) {
         System.out.printf("\t%-13s %-40s %-5s", textos[0], nomPCorto, existeNom ? textos[1] : textos[21]);
         if (existeNom) {
            String var10001 = esPackNom ? textos[22] : textos[23];
            System.out.print(var10001 + textos[10]);
         }

         System.out.println();
      }

      respuesta = existeNom & esPackNom;

      for(int i = 1; i < ficheros[p].length; ++i) {
         String nomFCorto = nomPCorto + SEP + ficheros[p][i];
         String nomFile = nom + SEP + ficheros[p][i];
         if (p == 0 && i <= 2 || 1 <= p && p <= 4 || p == 5 && i != 1) {
            existeJ = (new File(nomFile + ".java")).exists();
            respuesta &= existeJ;
            if (verb) {
               System.out.printf("\t%-13s %-40s %-15s\n", textos[12], nomFCorto + ".java", existeJ ? textos[1] : textos[21]);
            }
         }

         existeC = (new File(nomFile + ".class")).exists();
         respuesta &= existeC;
         if (verb) {
            System.out.printf("\t%-13s %-40s %-15s\n", textos[12], nomFCorto + ".class", existeC ? textos[1] : textos[21]);
         }
      }

      return respuesta;
   }

   public static void main(String[] args) {
      Scanner tec = new Scanner(System.in);
      System.out.println("Elige el idioma en el que has hecho las pr\u00e1cticas.");
      System.out.println("Tria l'idioma en el que has fet les pr\u00e0ctiques.");
      System.out.println("Choose your lab activities language");
      setLanguage(leerInt(tec, "   1 Castellano, 2 Valenci\u00e0, 3 English: ", 1, 3));
      int parcial = leerInt(tec, textos[20], 1, 2);

      int op;
      do {
         boolean p0 = true;
         boolean p1 = true;
         boolean p2 = true;
         boolean p3 = true;
         boolean p4 = true;
         op = menu(tec, parcial);
         switch (op) {
            case 1:
               p0 = validarProyectoIIP(true);
               if (parcial == 1) {
                  System.out.println(textos[2]);
                  p1 = validarPractica(0, true);
                  System.out.println("\n" + textos[3]);
                  p2 = validarPractica(1, true);
                  System.out.println("\n" + textos[4]);
                  p3 = validarPractica(2, true);
                  verificarDirLibs(true);
               } else {
                  System.out.println(textos[5]);
                  p1 = validarPractica(3, true);
                  System.out.println("\n" + textos[6]);
                  p2 = validarPractica(4, true);
                  System.out.println("\n" + textos[7]);
                  p3 = validarPractica(5, true);
                  verificarLibrerias(true);
               }
               break;
            case 2:
               p0 = validarProyectoIIP(true);
               if (parcial == 1) {
                  System.out.println(textos[2]);
                  p1 = validarPractica(0, true);
               } else {
                  System.out.println(textos[5]);
                  p1 = validarPractica(3, true);
                  verificarDirLibs(true);
               }
               break;
            case 3:
               p0 = validarProyectoIIP(true);
               if (parcial == 1) {
                  System.out.println(textos[3]);
                  p2 = validarPractica(1, true);
               } else {
                  System.out.println(textos[6]);
                  p2 = validarPractica(4, true);
                  verificarLibrerias(true);
               }
               break;
            case 4:
               p0 = validarProyectoIIP(true);
               if (parcial == 1) {
                  System.out.println(textos[4]);
                  p3 = validarPractica(2, true);
                  verificarDirLibs(true);
               } else {
                  System.out.println(textos[7]);
                  p3 = validarPractica(5, true);
                  verificarLibrerias(true);
               }
               break;
            default:
               System.out.println("\n\n" + textos[17]);
         }

         if (op != 0 && (!p0 || !p1 || !p2 || !p3 || !p4)) {
            System.out.println(textos[25]);
         }
      } while(op != 0);

   }

   static {
      SEP = File.separator;
      PATH = new File(System.getProperty("user.dir"));
      String var10000 = PATH.getParent();
      RAIZ = var10000 + SEP + "iip";
      LIBS = RAIZ + SEP + "+libs";
      LIBR = System.getProperty("java.class.path").contains("graphLib.jar");
      practPorParcial = new int[][]{new int[0], {2, 3, 4}, {5, 6, 7}};
      cont = 0;
   }
}
