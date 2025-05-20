import java.util.Scanner;

public class Ejercicio11 {

    // Código Konami: ↑ ↑ ↓ ↓ ← → ← → B A
    static final String[] KONAMI = {
        "UP", "UP", "DOWN", "DOWN", "LEFT", "RIGHT", "LEFT", "RIGHT", "B", "A"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos = 0;
        System.out.println("Introduce el Código Konami (usa UP, DOWN, LEFT, RIGHT, B, A):");

        while (true) {
            String entrada = sc.nextLine().trim().toUpperCase();
            if (entrada.equals(KONAMI[pos])) {
                pos++;
                if (pos == KONAMI.length) {
                    System.out.println("¡Código Konami detectado!");
                    break;
                }
            } else {
                if (!entrada.isEmpty()) {
                    pos = 0;
                }
            }
        }
    }
}
