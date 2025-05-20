import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio09 {

    static String[] palabras = {
        "murcielago", "ordenador", "java", "teclado", "pantalla", "raton", "programa", "desarrollo", "codigo", "variable"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String palabra = palabras[rand.nextInt(palabras.length)];
        char[] oculta = ocultarLetras(palabra, rand);
        int intentos = 6;

        while (intentos > 0) {
            System.out.println("Palabra: " + new String(oculta));
            System.out.println("Intentos restantes: " + intentos);
            System.out.print("Introduce una letra o la palabra completa: ");
            String entrada = sc.nextLine().toLowerCase();

            if (entrada.length() == 1) {
                char letra = entrada.charAt(0);
                boolean acierto = false;
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == letra && oculta[i] == '_') {
                        oculta[i] = letra;
                        acierto = true;
                    }
                }
                if (!acierto) {
                    System.out.println("¡Fallaste!");
                    intentos--;
                }
            } else if (entrada.length() == palabra.length()) {
                if (entrada.equals(palabra)) {
                    System.out.println("¡Has acertado la palabra! Era: " + palabra);
                    return;
                } else {
                    System.out.println("¡Fallaste la palabra!");
                    intentos--;
                }
            } else {
                System.out.println("Entrada no válida.");
            }

            if (new String(oculta).equals(palabra)) {
                System.out.println("¡Has acertado la palabra! Era: " + palabra);
                return;
            }
        }
        System.out.println("¡Has perdido! La palabra era: " + palabra);
    }

    private static char[] ocultarLetras(String palabra, Random rand) {
        char[] resultado = palabra.toCharArray();
        int longitud = palabra.length();
        int maxOcultas = (int) (longitud * 0.6);
        Set<Integer> ocultas = new HashSet<>();
        while (ocultas.size() < maxOcultas) {
            int pos = rand.nextInt(longitud);
            if (resultado[pos] != '_') {
                resultado[pos] = '_';
                ocultas.add(pos);
            }
        }
        return resultado;
    }
}
