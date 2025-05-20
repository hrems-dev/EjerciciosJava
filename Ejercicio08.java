import java.util.Calendar;
import java.util.Date;

public class Ejercicio08 {

    static String[] regalos = {
        "Libro de Java", "Curso de Python", "Licencia de IDE", "Auriculares", "Teclado mecánico",
        "Ratón inalámbrico", "Monitor 4K", "Tarjeta regalo Amazon", "Camiseta geek", "Taza personalizada",
        "Pack de pegatinas", "Suscripción a revista", "Curso de Git", "Powerbank", "Altavoz Bluetooth",
        "Webcam HD", "Placa Arduino", "Raspberry Pi", "SSD externo", "Mochila tech", "Lámpara LED",
        "Curso de Docker", "Libro de algoritmos", "Sorpresa final"
    };

    public static String analizarFecha(Date fecha) {
        Calendar inicio = Calendar.getInstance();
        inicio.set(2022, Calendar.DECEMBER, 1, 0, 0, 0);
        inicio.set(Calendar.MILLISECOND, 0);

        Calendar fin = Calendar.getInstance();
        fin.set(2022, Calendar.DECEMBER, 24, 23, 59, 59);
        fin.set(Calendar.MILLISECOND, 999);

        if (fecha.before(inicio.getTime())) {
            long diff = inicio.getTimeInMillis() - fecha.getTime();
            return "Faltan " + formatearTiempo(diff) + " para que comience el calendario de aDEViento.";
        } else if (fecha.after(fin.getTime())) {
            long diff = fecha.getTime() - fin.getTimeInMillis();
            return "Han pasado " + formatearTiempo(diff) + " desde que finalizó el calendario de aDEViento.";
        } else {
            Calendar dia = Calendar.getInstance();
            dia.setTime(fecha);
            int day = dia.get(Calendar.DAY_OF_MONTH);
            int index = day - 1;
            if (index >= 0 && index < regalos.length) {
                Calendar finDia = Calendar.getInstance();
                finDia.set(2022, Calendar.DECEMBER, day, 23, 59, 59);
                finDia.set(Calendar.MILLISECOND, 999);
                long diff = finDia.getTimeInMillis() - fecha.getTime();
                return "Regalo del día " + day + ": " + regalos[index] +
                        ". Quedan " + formatearTiempo(diff) + " para que finalice el sorteo de este día.";
            } else {
                return "No hay regalo para este día.";
            }
        }
    }

    private static String formatearTiempo(long millis) {
        long segundos = millis / 1000;
        long dias = segundos / (24 * 3600);
        segundos %= (24 * 3600);
        long horas = segundos / 3600;
        segundos %= 3600;
        long minutos = segundos / 60;
        segundos %= 60;
        return dias + " días, " + horas + " horas, " + minutos + " minutos, " + segundos + " segundos";
    }

    public static void main(String[] args) {
        // Ejemplo: 5 de diciembre de 2022, 12:30:00
        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.DECEMBER, 5, 12, 30, 0);
        Date fecha = cal.getTime();
        System.out.println(analizarFecha(fecha));

        // Antes del calendario
        cal.set(2022, Calendar.NOVEMBER, 30, 23, 59, 59);
        System.out.println(analizarFecha(cal.getTime()));

        // Después del calendario
        cal.set(2022, Calendar.DECEMBER, 25, 0, 0, 0);
        System.out.println(analizarFecha(cal.getTime()));
    }
}
