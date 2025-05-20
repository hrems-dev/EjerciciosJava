public class Ejercicio13 {

    public static boolean esExpresionMatematicaValida(String expresion) {
        if (expresion == null || expresion.trim().isEmpty()) return false;
        String[] tokens = expresion.trim().split(" ");
        if (tokens.length < 3 || tokens.length % 2 == 0) return false;

        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) {
                // Debe ser número (positivo, negativo, entero o decimal)
                if (!tokens[i].matches("^-?\\d+(\\.\\d+)?$")) return false;
            } else {
                // Debe ser operación válida
                if (!tokens[i].matches("[+\\-*/%]")) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(esExpresionMatematicaValida("5 + 6 / 7 - 4")); // true
        System.out.println(esExpresionMatematicaValida("5 a 6")); // false
        System.out.println(esExpresionMatematicaValida("-3.5 * 2 + 7")); // true
        System.out.println(esExpresionMatematicaValida("7 +")); // false
    }
}
