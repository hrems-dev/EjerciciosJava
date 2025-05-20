public class Ejercicio04 {

    public static String analizarTicTacToe(String[][] matriz) {
        int countX = 0, countO = 0, countVacio = 0;
        int size = 3;
        boolean xGana = false, oGana = false;

        // Contar X, O y vacíos
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String val = matriz[i][j];
                if ("X".equals(val)) countX++;
                else if ("O".equals(val)) countO++;
                else if ("".equals(val)) countVacio++;
                else return "Nulo"; // Valor no válido
            }
        }

        // Proporción incorrecta
        if (countX < countO || countX - countO > 1) return "Nulo";
        // Comprobar filas, columnas y diagonales
        for (int i = 0; i < size; i++) {
            // Filas
            if (matriz[i][0].equals(matriz[i][1]) && matriz[i][1].equals(matriz[i][2]) && !"".equals(matriz[i][0])) {
                if ("X".equals(matriz[i][0])) xGana = true;
                if ("O".equals(matriz[i][0])) oGana = true;
            }
            // Columnas
            if (matriz[0][i].equals(matriz[1][i]) && matriz[1][i].equals(matriz[2][i]) && !"".equals(matriz[0][i])) {
                if ("X".equals(matriz[0][i])) xGana = true;
                if ("O".equals(matriz[0][i])) oGana = true;
            }
        }
        // Diagonales
        if (matriz[0][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][2]) && !"".equals(matriz[0][0])) {
            if ("X".equals(matriz[0][0])) xGana = true;
            if ("O".equals(matriz[0][0])) oGana = true;
        }
        if (matriz[0][2].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][0]) && !"".equals(matriz[0][2])) {
            if ("X".equals(matriz[0][2])) xGana = true;
            if ("O".equals(matriz[0][2])) oGana = true;
        }

        if (xGana && oGana) return "Nulo";
        if (xGana) return "X";
        if (oGana) return "O";
        if (countVacio == 0) return "Empate";
        return "Empate"; // Si no hay ganador y puede haber vacíos, se considera empate
    }
    public static void main(String[] args) {
        String[][] matriz = {
            {"X", "O", "X"},
            {"O", "X", "O"},
            {"O", "X", "X"}
        };
        String resultado = analizarTicTacToe(matriz);
        System.out.println("Resultado: " + resultado);
    }
}
