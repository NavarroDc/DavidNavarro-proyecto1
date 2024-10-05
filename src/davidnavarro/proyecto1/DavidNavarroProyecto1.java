package davidnavarro.proyecto1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DavidNavarroProyecto1 {

    static boolean volverMenuPrincipal = false;
    static ArrayList<Orden> ordenes = new ArrayList();
    static Orden ordenActual = new Orden();

    public static void main(String[] args) {

        menuPrincipal();

    }

    public static void menuPrincipal() {
        Scanner seleccion = new Scanner(System.in);
        boolean opcionCorrecta = false;
        boolean continuarOrden = false;
        //boolean continuarAgregarNum = false;
        boolean salir = false;
        int seleccionMenu = 0;

        do {
            try {
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Opciones del restaurante, elija una opción:");
                System.out.println("");
                System.out.println("1. Creación de productos");
                System.out.println("2. Toma de órdenes");
                System.out.println("3. Ingresar otra orden");
                System.out.println("4. Reporte final ");
                System.out.println("5. Salir");

                seleccionMenu = Integer.parseInt(seleccion.nextLine());

                if (seleccionMenu >= 1 && seleccionMenu <= 4) {

                    opcionCorrecta = true;
                } else {
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Debe ingresar un número del 1 al 4");
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("");
                    opcionCorrecta = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Debe introducir un número en el apartado del menú");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");

            }
            Scanner leerDatosProducto = new Scanner(System.in);
            switch (seleccionMenu) {

                case 1:
                    do {
                        String nuevoNombreProducto = solicitarNombreProducto(leerDatosProducto);
                        double nuevoPrecioCorrecto = solicitarPrecioProducto(leerDatosProducto);
                        int nuevaCantidadProducto = solicitarCantidadProducto(leerDatosProducto);
                        Producto productoCreado = new Producto(nuevoNombreProducto, nuevoPrecioCorrecto, nuevaCantidadProducto);
                        ordenActual.agregarProducto(productoCreado);
                        continuarOrden = ingresarOtroProducto(leerDatosProducto);

                    } while (continuarOrden);
                    break;

                case 2:

                    solicitarNumOrden();
                    Date nuevaFecha = solicitarFecha(leerDatosProducto);
                    //El detalle de la orden se asignó en la opción 1 
                    String nuevoNombreCliente = solicitarNombreCliente(leerDatosProducto);
                    int descuentoAplicado = solicitarDescuento(leerDatosProducto);
                    double totalFinalProductos = ordenActual.totalFinal();

                    ordenActual.setFechaOrden(nuevaFecha);
                    ordenActual.setNombreCliente(nuevoNombreCliente);
                    ordenActual.setDescuento(descuentoAplicado);
                    ordenActual.setTotal(totalFinalProductos);

                    break;

                case 3:
                    preguntarNuevaOrden();
                    break;

                case 4:
                    mostrarDatos();
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
            }
            if (salir) {
                break;
            }

        } while (!opcionCorrecta || volverMenuPrincipal || !salir);
        seleccion.close();
    }

    public static void solicitarNumOrden() {
        boolean numeroValido = false;
        Scanner lecturaDatos = new Scanner(System.in);

        do {
            try {
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Escriba el número de la orden");
                int nuevoNumOrden = Integer.parseInt(lecturaDatos.nextLine());
                ordenActual.crearNumOrden(nuevoNumOrden);
                numeroValido = true;

            } catch (NumberFormatException e) {
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Error, debe introducir un número para continuar");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");
            }
        } while (!numeroValido);
    }

    public static void preguntarNuevaOrden() {
        Scanner leerOrdenNueva = new Scanner(System.in);
        String nuevaOrden = "";
        System.out.println("¿Desea agregar otra orden? S/N");
        nuevaOrden = leerOrdenNueva.nextLine();
        nuevaOrden = nuevaOrden.toUpperCase();
        boolean eleccionValida = validarSoN(nuevaOrden);

        if (eleccionValida) {

            ordenes.add(ordenActual);
            System.out.println("Tamaño");
            System.out.println(ordenes.size());

            ordenActual = new Orden();
        }
    }

    public static String solicitarNombreProducto(Scanner leerNombre) {
        System.out.println("");
        System.out.println("----------------------------------------------------------------------");
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
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Debe ingresar un número para que el precio sea válido");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");

            }
        } while (!precioCorrecto); //Ejecutarse mientras precioCorrecto esté NEGADO

        return nuevoPrecioProducto;
    }

    public static int solicitarCantidadProducto(Scanner leerCantidad) {
        boolean cantidadCorrecta = false;
        int nuevoCantidadProducto = 0;

        do {
            try {
                System.out.println("");
                System.out.println("Ingrese la cantidad del producto");
                String cantidadIngresada = leerCantidad.nextLine();
                nuevoCantidadProducto = Integer.parseInt(cantidadIngresada);

                cantidadCorrecta = true;

            } catch (NumberFormatException e) {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Debe ingresar un número para que la cantidad sea válida");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");
            }
        } while (!cantidadCorrecta); //Ejecutarse mientras precioCorrecto esté NEGADO

        return nuevoCantidadProducto;
    }

    public static Date solicitarFecha(Scanner leerFecha) {
        boolean fechaValida = false;
        System.out.println("");
        System.out.println("Ingrese la fecha en la que crea la orden (Debe escribir en este formato dd/MMM/aaa) Por ejemplo: 2/feb/2024...");

        Date nuevaFecha = null;

        do {
            String fechaIngresada = leerFecha.nextLine();

            SimpleDateFormat fechaFormateada = new SimpleDateFormat("dd/MMM/yyyy", Locale.forLanguageTag("es-ES"));
            fechaFormateada.setLenient(false);

            try {
                nuevaFecha = fechaFormateada.parse(fechaIngresada);
                fechaValida = true;
            } catch (ParseException errorParse) {
                //System.out.println(errorParse);
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("La fecha es inválida, debe seguir el formato dd/MMM/aaaa");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");
            }
        } while (!fechaValida);

        return nuevaFecha;
    }

    public static String solicitarNombreCliente(Scanner leerNombreCliente) {
        System.out.println("");
        System.out.println("Ingrese el nombre del cliente");
        String nuevoNombreCliente = leerNombreCliente.nextLine();
        System.out.println("");

        return nuevoNombreCliente;
    }

    public static int solicitarDescuento(Scanner leerDescuento) {
        boolean descuentoCorrecto = false;
        String nuevoDescuento;
        int descuentoAplicado = 0;

        do {
            System.out.println("Ingrese el cógido de descuento: DSC5 = 5% / DSC10 = 10% / DSC15 = 15% / 0 = No se aplica descuento");
            String descuentoIngresado = leerDescuento.nextLine();
            nuevoDescuento = descuentoIngresado.toUpperCase();

            if (nuevoDescuento.equals("DSC5")) {
                descuentoCorrecto = true;
                descuentoAplicado = 5;
            } else if (nuevoDescuento.equals("DSC10")) {
                descuentoCorrecto = true;
                descuentoAplicado = 10;
            } else if (nuevoDescuento.equals("DSC15")) {
                descuentoCorrecto = true;
                descuentoAplicado = 15;
            } else if (nuevoDescuento.equals("0")) {
                descuentoCorrecto = true;
                descuentoAplicado = 0;
            } else {
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("No ingresó un descuento válido...");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");
            }

        } while (!descuentoCorrecto);

        return descuentoAplicado;
    }

    public static void mostrarDatos() {

        for (Orden orden : ordenes) {
            System.out.println(orden.toString());
        }
    }

    public static boolean validarSoN(String eleccion) {
        boolean eleccionCorrecta = true;

        if (!eleccion.equals("S") && !eleccion.equals("N")) {
            eleccionCorrecta = false;
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Debe ingresar solo S o N");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("");

        } else {
            eleccionCorrecta = true;

        }
        return eleccionCorrecta;
    }

    public static boolean ingresarOtroProducto(Scanner leerContinuar) {
        boolean respuestaValida = false;
        boolean continuar = false;
        String respuestaSN = "";

        do {
            System.out.println("");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("¿Desea ingresar otro producto? S/N");
            String desicionAgregar = leerContinuar.nextLine();
            respuestaSN = desicionAgregar.toUpperCase();

            respuestaValida = validarSoN(respuestaSN);
        } while (!respuestaValida);

        if (respuestaValida) {

            if (respuestaSN.equals("S")) {
                continuar = true;
            } else {
                continuar = false;
                volverMenuPrincipal = true;
            }
        } else {
            System.out.println("Solo se permite escribir S o N");
        }

        return continuar;
    }

}
