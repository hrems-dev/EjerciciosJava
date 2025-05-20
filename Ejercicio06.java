public class Ejercicio06 {

    public static double calcularEfectividad(String atacante, String defensor) {
        // Agua, Fuego, Planta, Eléctrico
        if (atacante.equals("Agua")) {
            if (defensor.equals("Fuego")) return 2.0;
            if (defensor.equals("Planta") || defensor.equals("Agua")) return 0.5;
            if (defensor.equals("Eléctrico")) return 1.0;
        }
        if (atacante.equals("Fuego")) {
            if (defensor.equals("Planta")) return 2.0;
            if (defensor.equals("Agua") || defensor.equals("Fuego")) return 0.5;
            if (defensor.equals("Eléctrico")) return 1.0;
        }
        if (atacante.equals("Planta")) {
            if (defensor.equals("Agua")) return 2.0;
            if (defensor.equals("Fuego") || defensor.equals("Planta")) return 0.5;
            if (defensor.equals("Eléctrico")) return 1.0;
        }
        if (atacante.equals("Eléctrico")) {
            if (defensor.equals("Agua")) return 2.0;
            if (defensor.equals("Planta") || defensor.equals("Eléctrico")) return 0.5;
            if (defensor.equals("Fuego")) return 1.0;
        }
        return 1.0; // Por defecto neutral
    }

    public static double calcularDanio(String tipoAtacante, String tipoDefensor, int ataque, int defensa) {
        double efectividad = calcularEfectividad(tipoAtacante, tipoDefensor);
        return 50 * ((double)ataque / defensa) * efectividad;
    }

    public static void main(String[] args) {
        String tipoAtacante = "Agua";
        String tipoDefensor = "Fuego";
        int ataque = 80;
        int defensa = 60;
        double danio = calcularDanio(tipoAtacante, tipoDefensor, ataque, defensa);
        System.out.println("Daño causado: " + danio);
    }
}
