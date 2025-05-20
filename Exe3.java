import java.util.Random;
import java.util.Scanner;
public class Exe3 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        //System.out.println("ingrese nombre de jugador");
        //String jug1=s.nextLine();
        //System.out.println("Ingrese el numero de segundo jugador");
        //String jug2=s.nextLine();
       String mac[][] = new String[3][3];
       Random r= new Random();
       int val=0,val1=0;
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                boolean date=r.nextBoolean();

                if(date==true){
                    val++;
                }else if(date==false){
                    val1++;
                }
                if(val>4 || val1>4){
                   mac[i][j]="O";
                   j--;
                }else{
                    String valor=date?"X":"O";
                    mac[i][j]= valor;
                }
                 //System.out.println(mac[i][j]);
            }
            //System.out.println();
        }
        // impresion
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(mac[i][j]);
            }
            System.out.println();
        }

    }
}
