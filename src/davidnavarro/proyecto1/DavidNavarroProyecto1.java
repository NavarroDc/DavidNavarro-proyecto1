package davidnavarro.proyecto1;

import java.util.Date;
import java.util.Scanner;

public class DavidNavarroProyecto1 {
    
    

    public static void main(String[] args) {
        Orden objOrden = new Orden();
   
        menuPrincipal();///acá la llamo
        }
    //supongamos que aquí hago toda la funcionalidad del la función
    public static void menuPrincipal(){
        Scanner seleccion = new Scanner(System.in);
        boolean opcionCorrecta = false;
        int seleccionMenu = 0;

        do {
            try {
                System.out.println("Opciones del restaurante, elija una opción:");
                System.out.println("");
                System.out.println("1. Creación de productos");
                System.out.println("2. Toma de órdenes");
                System.out.println("3. Ingreso de productos y precios ");
                System.out.println("4. Reporte final");

                seleccionMenu = Integer.parseInt(seleccion.nextLine());

                if (seleccionMenu >= 1 && seleccionMenu <= 4) {

                    opcionCorrecta = true;
                } else {
                    System.out.println("Debe ingresar un número del 1 al 4");
                    opcionCorrecta = false;
                }
            } catch (NumberFormatException e){
                System.out.println("Debe introducir un número en el apartado del menú");
            }
            
            switch(seleccionMenu){
                
                case 1: 
                    Orden nuevaOrden = new Orden();
                    Scanner leerDatosProducto = new Scanner (System.in);
                    boolean precioCorrecto = false;
                    
                    System.out.println("Ingrese el nombre del producto para crearlo");
                    String nuevoNombreProducto = leerDatosProducto.nextLine();
                    System.out.println("");
                    
                    do{
                    try{
                    System.out.println("Ingrese el precio del producto");
                    String precioIngresado = leerDatosProducto.nextLine();
                    Double nuevoPrecioProducto = Double.parseDouble(precioIngresado);
                    Producto nuevoProducto = new Producto(nuevoNombreProducto, nuevoPrecioProducto);
                    nuevaOrden.agregarProducto (nuevoProducto);
                    precioCorrecto = true;
                    }catch(NumberFormatException e){
                        System.out.println("Debe ingresar un número para que el precio sea válido...");
                    }
                    }while(precioCorrecto == false);
                break;
                
                case 2: System.out.println("Op2");
                break;
                
                case 3: System.out.println("Op3");
                break;
                
                case 4: System.out.println("Op4");
                break;
            }
            }while (opcionCorrecta == false);
            seleccion.close();
    }
    }
