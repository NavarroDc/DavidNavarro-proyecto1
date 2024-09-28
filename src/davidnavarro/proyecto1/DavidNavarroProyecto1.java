package davidnavarro.proyecto1;

import java.util.Date;
import java.util.Scanner;

public class DavidNavarroProyecto1 {

    public static void main(String[] args) {

        Scanner seleccion = new Scanner(System.in);
        boolean opcionCorrecta = false;

        do {
            try {
                System.out.println("Opciones del restaurante, elija una opción:");
                System.out.println("");
                System.out.println("1. Creación de productos");
                System.out.println("2. Toma de órdenes");
                System.out.println("3. Ingreso de productos y precios ");
                System.out.println("4. Reporte final");

                int seleccionMenu = Integer.parseInt(seleccion.nextLine());

                if (seleccionMenu >= 1 && seleccionMenu <= 4) {

                    opcionCorrecta = true;
                } else {
                    System.out.println("Debe ingresar un número del 1 al 4");
                    opcionCorrecta = false;
                   
                }

            } catch (NumberFormatException e){
                System.out.println("Debe introducir un número en el apartado del menú");
                
            } 
                
            }while (opcionCorrecta == false);
                
            seleccion.close();
        }
    
        
    
    }
