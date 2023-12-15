import java.util.*;

public class DrawingFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        StringBuilder finalSol = new StringBuilder();

        while (scan.hasNext()) {
            String line = scan.nextLine().trim();

            if (!line.isEmpty()) {
                String[] pieces = line.split("\\s+");
                String w = pieces[0], s = pieces[2];
                int n = Integer.parseInt(pieces[1]);

                switch (w) {
                    case "triangle":
                        finalSol.append(drawTriangle(n, s));
                        break;
                    case "left-arrow":
                        finalSol.append(drawLeftArrow(n, s));
                        break;
                    case "right-arrow":
                        finalSol.append(drawRightArrow(n, s));
                        break;
                    case "square":
                        finalSol.append(drawSquare(n, s));
                        break;
                    case "down-arrow":
                        finalSol.append(drawDownArrow(n, s));
                        break;
                    case "trapecious":
                        finalSol.append(drawTrapezious(n, s));
                        break;
                    case "diamond":
                        finalSol.append(drawDiamond(n, s));
                        break;
                }
                finalSol.append("\n");
            }
        }
        System.out.println(finalSol.toString().trim());
    }

    private static String drawTriangle(int n, String s) {
        StringBuilder sol = new StringBuilder();
        String spaces = " ";
        int i = 1, k = n - 1;
        for (int j = 0; j < n; j++) {
            sol.append(repeatChar(spaces, k)).append(repeatChar(s, i)).append("\n");
            i += 2;
            k -= 1;
        }
        return sol.toString();
    }

    private static String drawLeftArrow(int n, String s) {
        StringBuilder sol = new StringBuilder();
        String spaces = " ";
        int i = 2 * n - 2, k = 1;

        for (int j = 0; j < n; j++) {
            sol.append(repeatChar(spaces, i)).append(repeatChar(s, k)).append("\n");
            k += 2;
            i -= 2;
        }
        k -= 2;
        i += 2;

        for (int j = 1; j < n; j++) {
            i += 2;
            k -= 2;
            sol.append(repeatChar(spaces, i)).append(repeatChar(s, k)).append("\n");
        }
        return sol.toString();
    }

    private static String drawRightArrow(int n, String s) {
        StringBuilder sol = new StringBuilder();
        int k = 1;

        for (int j = 0; j < n; j++) {
            sol.append(repeatChar(s, k)).append("\n");
            k += 2;
        }

        for (int i = 2 * n - 3; i > 0; i -= 2) {
            sol.append(repeatChar(s, i)).append("\n");
        }
        return sol.toString();
    }

    private static String drawSquare(int n, String s) {
        StringBuilder sol = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sol.append(repeatChar(s, n*2)).append("\n");
        }
        return sol.toString();
    }

    private static String drawDownArrow(int n, String s) {
        StringBuilder sol = new StringBuilder();
        String spaces = " ";
        int i = 2 * n - 1;

        for (int j = 0; j < n; j++) {
            sol.append(repeatChar(spaces, j)).append(repeatChar(s, i)).append("\n");
            i -= 2;
        }
        return sol.toString();
    }

    private static String drawTrapezious(int n, String s) {
        StringBuilder sol = new StringBuilder();
        String spaces = " ";
        int i = n, k = n - 1;

        for (int j = 0; j < n; j++) {
            sol.append(repeatChar(spaces, k)).append(repeatChar(s, i)).append("\n");
            i += 2;
            k--;
        }
        return sol.toString();
    }

    private static String drawDiamond(int n, String s) {
        StringBuilder sol = new StringBuilder();
        String spaces = " ";
        int i = 1, k = n - 1;

        for (int j = 0; j < n; j++) {
            sol.append(repeatChar(spaces, k)).append(repeatChar(s, i)).append("\n");
            i += 2;
            k -= 1;
        }

        k++;
        i -= 2;

        for (int j = 1; j < n; j++) {
            k++;
            i -= 2;
            sol.append(repeatChar(spaces, k)).append(repeatChar(s, i)).append("\n");
        }
        return sol.toString();
    }

    private static String repeatChar(String c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
