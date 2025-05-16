import java.util.Scanner;
public class Ejercicio01 {
    public static void main(String[] args) {
        System.out.println("FIFONACCI");
        Scanner sc = new Scanner(System.in);
         for(int i = 0; i < 50; i++){
            System.out.print(fibonacci(i) + " ");
         }
    }
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
