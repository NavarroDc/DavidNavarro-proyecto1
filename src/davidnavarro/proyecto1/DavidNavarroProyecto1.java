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
                System.out.println("Opciones del restaurante, elija una opci�n:");
                System.out.println("");
                System.out.println("1. Creaci�n de productos");
                System.out.println("2. Toma de �rdenes");
                System.out.println("3. Ingreso de productos y precios ");
                System.out.println("4. Reporte final");

                seleccionMenu = Integer.parseInt(seleccion.nextLine());

                if (seleccionMenu >= 1 && seleccionMenu <= 4) {

                    opcionCorrecta = true;
                } else {
                    System.out.println("Debe ingresar un n�mero del 1 al 4");
                    opcionCorrecta = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un n�mero en el apartado del men�");
            }

            switch (seleccionMenu) {

                case 1:
                    Scanner leerDatosProducto = new Scanner(System.in);
                    boolean precioCorrecto = false;

                    System.out.println("Ingrese el nombre del producto para crearlo");
                    String nuevoNombreProducto = leerDatosProducto.nextLine();
                    System.out.println("");

                    do {
                        try {
                            System.out.println("Ingrese el precio del producto");
                            String precioIngresado = leerDatosProducto.nextLine();
                            Double nuevoPrecioProducto = Double.parseDouble(precioIngresado);
                            Producto nuevoProducto = new Producto(nuevoNombreProducto, nuevoPrecioProducto);
                            ordenActual.agregarProducto(nuevoProducto);
                            precioCorrecto = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un n�mero para que el precio sea v�lido...");
                        }
                    } while (precioCorrecto == false);
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

        System.out.println("Escriba el n�mero de la orden");
        int nuevoNumOrden = Integer.parseInt(lecturaDatos.nextLine());

        ordenActual.crearNumOrden(nuevoNumOrden);
    }
}
