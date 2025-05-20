// fechas 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
public class Ejercicio02 {
    public static void main(String[] args) {
         try {
            String fechaA = "25/12/2023";
            String fechaB = "01/01/2024";
            
            int dias = diferenciaDias(fechaA, fechaB);
            System.out.println("Días de diferencia: " + dias);
            
        } catch (DateTimeParseException e) {
            System.err.println("Error: Una de las fechas no tiene el formato correcto (dd/MM/yyyy) o es inválida.");
        }
    }
    public static int diferenciaDias(String fecha1, String fecha2) throws DateTimeParseException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    // Parsear las fechas y validar su formato
    LocalDate date1 = LocalDate.parse(fecha1, formatter);
    LocalDate date2 = LocalDate.parse(fecha2, formatter);
    
    // Calcular la diferencia absoluta en días
    long diferencia = ChronoUnit.DAYS.between(date1, date2);
    
    return Math.abs((int)diferencia);
}
}
