package davidnavarro.proyecto1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DavidNavarroProyecto1 {

    static ArrayList<Orden> ordenes = new ArrayList();
    static Orden ordenActual = new Orden();

    public static void main(String[] args) {

        menuPrincipal();

    }

    public static void menuPrincipal() {
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
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número en el apartado del menú");
            }

            switch (seleccionMenu) {

                case 1:
                    Scanner leerDatosProducto = new Scanner(System.in);

                    String nuevoNombreProducto = solicitarNombreProducto(leerDatosProducto);
                    double nuevoPrecioCorrecto = solicitarPrecioProducto(leerDatosProducto);
                    int nuevaCantidadProducto = solicitarCantidadProducto(leerDatosProducto);
                    break;

                case 2:
                    System.out.println("Op2");
                    break;

                case 3:
                    System.out.println("Op3");
                    break;

                case 4:
                    System.out.println("Op4");
                    break;
            }
        } while (opcionCorrecta == false);
        seleccion.close();
    }

    public static void solicitarNumOrden() {
        Scanner lecturaDatos = new Scanner(System.in);

        System.out.println("Escriba el número de la orden");
        int nuevoNumOrden = Integer.parseInt(lecturaDatos.nextLine());

        ordenActual.crearNumOrden(nuevoNumOrden);
    }

    public static String solicitarNombreProducto(Scanner leerNombre) {

        System.out.println("Ingrese el nombre del producto para crearlo");
        String nuevoNombreProducto = leerNombre.nextLine();
        System.out.println("");

        return nuevoNombreProducto;
    }

    public static double solicitarPrecioProducto(Scanner leerPrecio) {
        boolean precioCorrecto = false;
        double nuevoPrecioProducto = 0.0;

        do {
            try {
                System.out.println("Ingrese el precio del producto");
                String precioIngresado = leerPrecio.nextLine();
                nuevoPrecioProducto = Double.parseDouble(precioIngresado);

                precioCorrecto = true;

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número para que el precio sea válido");
            }
        } while (!precioCorrecto); //Ejecutarse mientras precioCorrecto esté NEGADO

        return nuevoPrecioProducto;
    }

    public static int solicitarCantidadProducto(Scanner leerCantidad) {
        boolean cantidadCorrecta = false;
        int nuevoCantidadProducto = 0;

        do {
            try {
                System.out.println("Ingrese la cantidad del producto");
                String cantidadIngresada = leerCantidad.nextLine();
                nuevoCantidadProducto = Integer.parseInt(cantidadIngresada);

                cantidadCorrecta = true;

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número para que la cantidad sea válida");
            }
        } while (!cantidadCorrecta); //Ejecutarse mientras precioCorrecto esté NEGADO

        return nuevoCantidadProducto;
    }
    
    public static String solicitarNombreCliente(Scanner leerNombreCliente){
        System.out.println("Ingrese el nombre del cliente");
        String nuevoNombreCliente = leerNombreCliente.nextLine();
        System.out.println("");

        return nuevoNombreCliente;
    }
    /*public static Date solicitarFecha (Scanner leerFecha){  
    }*/
}
