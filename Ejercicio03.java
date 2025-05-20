public class Ejercicio03 {
    public static void main(String[] args) {
        String[] acciones = {"run", "jump", "run", "jump"};
        String pista = "_|_|";
        boolean resultado = evaluarCarrera(acciones, pista);
        System.out.println("¿Ha superado la carrera? " + resultado);
    }

    public static boolean evaluarCarrera(String[] acciones, String pista) {
        StringBuilder pistaFinal = new StringBuilder(pista);
        boolean superada = true;

        for (int i = 0; i < acciones.length && i < pista.length(); i++) {
            String accion = acciones[i];
            char tramo = pista.charAt(i);

            if (accion.equals("run") && tramo == '_') {
                // Correcto, no cambia nada
            } else if (accion.equals("jump") && tramo == '|') {
                // Correcto, no cambia nada
            } else if (accion.equals("jump") && tramo == '_') {
                pistaFinal.setCharAt(i, 'x');
                superada = false;
            } else if (accion.equals("run") && tramo == '|') {
                pistaFinal.setCharAt(i, '/');
                superada = false;
            }
        }

        System.out.println("Pista final: " + pistaFinal);
        return superada;
    }
}
