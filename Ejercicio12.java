public class Ejercicio12 {

    public static void cuentaAtras(int inicio, int segundos) {
        if (inicio <= 0 || segundos <= 0) {
            System.out.println("Parámetros no válidos. Deben ser enteros positivos.");
            return;
        }
        for (int i = inicio; i >= 0; i--) {
            System.out.println(i);
            if (i > 0) {
                try {
                    Thread.sleep(segundos * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Cuenta atrás interrumpida.");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        cuentaAtras(5, 1); // Ejemplo: cuenta atrás desde 5, cada 1 segundo
    }
}
