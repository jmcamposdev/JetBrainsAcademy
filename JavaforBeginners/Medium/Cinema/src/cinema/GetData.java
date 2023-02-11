package cinema;

import java.util.Scanner;

public class GetData {

    /*
        ------------------------------------------------
        GET INT
        ------------------------------------------------
     */
    //  INT SIN RANGO
    public static int getInt(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        while (!sc.hasNextInt()){
            System.out.println("Ingrese un valor numérico.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        numero = sc.nextInt();
        return numero;
    }
    //  INT CON MÍNIMO (el mínimo está incluido en valores válidos)
 public static int getInt(String mensaje, int minimo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextInt();
            if (numero < minimo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo);
        return numero;
    }

    //  INT CON MÍNIMO Y MÁXIMO(el mínimo está incluido en valores válidos)
    public static int getInt(String mensaje, int minimo, int maximo) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextInt();
            if (numero < minimo || numero > maximo){
                System.out.println("Wrong input!");
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }
}

