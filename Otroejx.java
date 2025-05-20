
import java.util.Scanner;
public class Otroejx {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el primer numero");
        int nr1= sc.nextInt();
        System.out.println("ingrese el segundo numero");
        int nro2=sc.nextInt();
        //double res= nr1/nro2;
        if(nr1%nro2==0){
            System.out.println("son multiplos");
        }else{
            System.out.println("no son we");
        }
    }
}
