public class Ejercicio14 {

    /**
     * Calcula el punto de encuentro de dos objetos en movimiento en 2D.
     * @param x1 Posición inicial x del objeto 1
     * @param y1 Posición inicial y del objeto 1
     * @param vx1 Velocidad x del objeto 1
     * @param vy1 Velocidad y del objeto 1
     * @param x2 Posición inicial x del objeto 2
     * @param y2 Posición inicial y del objeto 2
     * @param vx2 Velocidad x del objeto 2
     * @param vy2 Velocidad y del objeto 2
     */
    public static void puntoEncuentro(
            double x1, double y1, double vx1, double vy1,
            double x2, double y2, double vx2, double vy2) {

        // Resolver: x1 + vx1*t = x2 + vx2*t  y  y1 + vy1*t = y2 + vy2*t
        // <=> (vx1-vx2)*t = x2-x1   y   (vy1-vy2)*t = y2-y1

        double dx = x2 - x1;
        double dy = y2 - y1;
        double dvx = vx1 - vx2;
        double dvy = vy1 - vy2;

        Double tX = null, tY = null;

        if (dvx != 0) tX = dx / dvx;
        else if (dx != 0) {
            System.out.println("No hay encuentro: los objetos nunca coinciden en X.");
            return;
        }

        if (dvy != 0) tY = dy / dvy;
        else if (dy != 0) {
            System.out.println("No hay encuentro: los objetos nunca coinciden en Y.");
            return;
        }

        // Ambos se mueven igual en X e Y y están en el mismo punto
        if (dvx == 0 && dvy == 0) {
            if (dx == 0 && dy == 0) {
                System.out.println("Los objetos ya están en el mismo punto (t=0).");
            } else {
                System.out.println("No hay encuentro: trayectorias paralelas.");
            }
            return;
        }

        // Si ambos tX y tY existen, deben ser iguales y >= 0
        if (tX != null && tY != null) {
            if (Math.abs(tX - tY) < 1e-8 && tX >= 0) {
                double px = x1 + vx1 * tX;
                double py = y1 + vy1 * tX;
                System.out.printf("Se encuentran en (%.4f, %.4f) tras %.4f unidades de tiempo.%n", px, py, tX);
            } else {
                System.out.println("No hay encuentro: los objetos no coinciden en el mismo instante.");
            }
            return;
        }

        // Si sólo una coordenada varía, el tiempo debe ser >= 0
        Double t = tX != null ? tX : tY;
        if (t != null && t >= 0) {
            double px = x1 + vx1 * t;
            double py = y1 + vy1 * t;
            System.out.printf("Se encuentran en (%.4f, %.4f) tras %.4f unidades de tiempo.%n", px, py, t);
        } else {
            System.out.println("No hay encuentro: el tiempo de encuentro no es válido.");
        }
    }

    public static void main(String[] args) {
        // Ejemplo: Se encuentran en (5,5) tras 1 unidad de tiempo
        puntoEncuentro(0, 0, 5, 5, 10, 10, -5, -5);

        // Ejemplo: No se encuentran
        puntoEncuentro(0, 0, 1, 0, 0, 1, 1, 0);

        // Ejemplo: Ya están juntos
        puntoEncuentro(2, 2, 1, 1, 2, 2, 1, 1);
    }
}
