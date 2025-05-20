public class Ejercicio07 {

    // Valores de las razas bondadosas: Pelosos, Sureños buenos, Enanos, Númenóreanos, Elfos
    static int[] valoresBien = {1, 2, 3, 4, 5};
    // Valores de las razas malvadas: Sureños malos, Orcos, Goblins, Huargos, Trolls
    static int[] valoresMal = {2, 2, 2, 3, 5};

    /**
     * Calcula el resultado de la batalla.
     * @param ejercitoBien array con la cantidad de cada raza bondadosa
     * @param ejercitoMal array con la cantidad de cada raza malvada
     * @return String con el resultado
     */
    public static String batalla(int[] ejercitoBien, int[] ejercitoMal) {
        int sumaBien = 0;
        int sumaMal = 0;
        for (int i = 0; i < valoresBien.length; i++) {
            sumaBien += ejercitoBien[i] * valoresBien[i];
        }
        for (int i = 0; i < valoresMal.length; i++) {
            sumaMal += ejercitoMal[i] * valoresMal[i];
        }
        if (sumaBien > sumaMal) return "Gana el Bien";
        if (sumaMal > sumaBien) return "Gana el Mal";
        return "Empate";
    }

    public static void main(String[] args) {
        // Ejemplo: 3 Pelosos, 0 Sureños buenos, 0 Enanos, 0 Númenóreanos, 0 Elfos
        int[] ejercitoBien = {3, 0, 0, 0, 0};
        // Ejemplo: 1 Orco (posición 1), el resto 0
        int[] ejercitoMal = {0, 1, 0, 0, 0};
        System.out.println(batalla(ejercitoBien, ejercitoMal)); // Gana el Bien

        // Otro ejemplo: 1 Peloso vs 1 Orco
        int[] bien2 = {1, 0, 0, 0, 0};
        int[] mal2 = {0, 1, 0, 0, 0};
        System.out.println(batalla(bien2, mal2)); // Gana el Mal

        // Otro ejemplo: 2 Pelosos vs 1 Orco
        int[] bien3 = {2, 0, 0, 0, 0};
        System.out.println(batalla(bien3, mal2)); // Empate
    }
}
