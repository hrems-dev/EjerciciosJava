import java.util.Random;
import java.util.Scanner;

public class Ejercicio15 {

    public static void simularClima(int dias, double tempInicial, double probLluviaInicial) {
        Random rand = new Random();
        double temp = tempInicial;
        double probLluvia = probLluviaInicial;
        double tempMax = temp;
        double tempMin = temp;
        int diasLluvia = 0;

        System.out.println("Día | Temperatura | ¿Llueve?");
        for (int d = 1; d <= dias; d++) {
            // 10% de posibilidades de variar la temperatura ±2 grados
            if (rand.nextDouble() < 0.1) {
                if (rand.nextBoolean()) {
                    temp += 2;
                } else {
                    temp -= 2;
                }
            }

            // Determinar si llueve
            boolean llueve = rand.nextDouble() < (probLluvia / 100.0);
            if (llueve) diasLluvia++;

            System.out.printf("%3d |    %6.2f°C  | %s%n", d, temp, llueve ? "Sí" : "No");

            // Actualizar máximos y mínimos
            if (temp > tempMax) tempMax = temp;
            if (temp < tempMin) tempMin = temp;

            // Reglas para el día siguiente
            if (temp > 25) {
                probLluvia = Math.min(100, probLluvia + 20);
            } else if (temp < 5) {
                probLluvia = Math.max(0, probLluvia - 20);
            }
            if (llueve) {
                temp -= 1;
            }
        }

        System.out.println("\nTemperatura máxima: " + tempMax + "°C");
        System.out.println("Temperatura mínima: " + tempMin + "°C");
        System.out.println("Días de lluvia: " + diasLluvia);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Temperatura inicial: ");
        double temp = sc.nextDouble();
        System.out.print("Probabilidad de lluvia inicial (%): ");
        double prob = sc.nextDouble();
        System.out.print("Número de días de predicción: ");
        int dias = sc.nextInt();

        simularClima(dias, temp, prob);
    }
}
