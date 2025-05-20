public class Ejercicio10 {

    public static void mostrarPrimosGemelos(int rangoMax) {
        for (int i = 2; i <= rangoMax - 2; i++) {
            if (esPrimo(i) && esPrimo(i + 2)) {
                System.out.println("(" + i + ", " + (i + 2) + ")");
            }
        }
    }

    private static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int rango = 14;
        System.out.println("Pares de primos gemelos hasta " + rango + ":");
        mostrarPrimosGemelos(rango);
    }
}
