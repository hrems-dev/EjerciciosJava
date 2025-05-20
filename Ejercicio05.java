import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio05 {

    static class Producto {
        String nombre;
        int precio; // en céntimos

        Producto(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
    }

    static Producto[] productos = {
        new Producto("Agua", 50),
        new Producto("Refresco", 120),
        new Producto("Chocolate", 90),
        new Producto("Patatas", 75)
    };

    static int[] monedasSoportadas = {200, 100, 50, 10, 5};

    public static Object[] comprarProducto(int[] monedas, int seleccion) {
        // Validar monedas
        for (int m : monedas) {
            boolean valida = false;
            for (int ms : monedasSoportadas) {
                if (m == ms) {
                    valida = true;
                    break;
                }
            }
            if (!valida) {
                return new Object[]{"Moneda no soportada", monedas};
            }
        }

        // Validar selección
        if (seleccion < 0 || seleccion >= productos.length) {
            return new Object[]{"Producto no existe", monedas};
        }

        Producto prod = productos[seleccion];
        int total = 0;
        for (int m : monedas) total += m;

        if (total < prod.precio) {
            return new Object[]{"Dinero insuficiente", monedas};
        }

        int cambio = total - prod.precio;
        List<Integer> monedasCambio = new ArrayList<>();
        for (int ms : monedasSoportadas) {
            while (cambio >= ms) {
                monedasCambio.add(ms);
                cambio -= ms;
            }
        }

        return new Object[]{prod.nombre, monedasCambio.stream().mapToInt(i -> i).toArray()};
    }

    public static void main(String[] args) {
        int[] monedas = {100, 50, 10, 5}; // 170 céntimos
        int seleccion = 2; // Refresco (120 céntimos)
        Object[] resultado = comprarProducto(monedas, seleccion);

        System.out.println("Resultado: " + resultado[0]);
        System.out.print("Cambio: ");
        int[] cambio = (int[]) resultado[1];
        System.out.println(Arrays.toString(cambio));
    }
}
