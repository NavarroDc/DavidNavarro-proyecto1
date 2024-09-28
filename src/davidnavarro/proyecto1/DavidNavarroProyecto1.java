package davidnavarro.proyecto1;

import java.util.Date;
import java.util.Scanner;

public class DavidNavarroProyecto1 {

    public static void main(String[] args) {

        Scanner seleccion = new Scanner(System.in);
        boolean opcionCorrecta = false;

        do {
            try {
                System.out.println("Opciones del restaurante, elija una opci�n:");
                System.out.println("");
                System.out.println("1. Creaci�n de productos");
                System.out.println("2. Toma de �rdenes");
                System.out.println("3. Ingreso de productos y precios ");
                System.out.println("4. Reporte final");

                int seleccionMenu = Integer.parseInt(seleccion.nextLine());

                if (seleccionMenu >= 1 && seleccionMenu <= 4) {

                    opcionCorrecta = true;
                } else {
                    System.out.println("Debe ingresar un n�mero del 1 al 4");
                    opcionCorrecta = false;
                   
                }

            } catch (NumberFormatException e){
                System.out.println("Debe introducir un n�mero en el apartado del men�");
                
            } 
                
            }while (opcionCorrecta == false);
                
            seleccion.close();
        }
    
        
    
    }
