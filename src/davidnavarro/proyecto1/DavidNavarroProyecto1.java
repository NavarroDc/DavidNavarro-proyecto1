//David Navarro Camacho
//Programación intermedia
//III Cuatrimestre
//Proyecto 1
//Profesora: Adriana Rubio Escobar

package davidnavarro.proyecto1;

import java.text.ParseException;//Para trabajar la excepción de la fecha
import java.text.SimpleDateFormat;//Para asignar un formato específico al momento de ingresar la fecha
import java.util.ArrayList;//Para trabajar con ArrayList
import java.util.Date;//Para trabajar con varibales de tipo Date
import java.util.Locale;//Para que permite y valide entradas en español de la fecha
import java.util.Scanner;//Para hacer uso de scanner y leer los datos

public class DavidNavarroProyecto1 {

    static boolean volverMenuPrincipal = false; //Variable para verificar si el usuario quiere volver al menú
    static ArrayList<Orden> ordenes = new ArrayList(); //Array list de tipo Orden para guardar órdenes
    static Orden ordenActual = new Orden(); //Instancia para trabajar con la clase Orden

    public static void main(String[] args) {

        menuPrincipal();//LLamado del método para el menú principál

    }
    
    //Se define el método para el menú principal
    public static void menuPrincipal() {
        //Variables para el funcionamiento de la función
        Scanner seleccion = new Scanner(System.in);
        boolean opcionCorrecta = false;
        boolean continuarOrden = false;
        boolean salir = false;
        int seleccionMenu = 0;

        do {//Se crea un ciclo do-while para el menú principal
            try {//Se inicia un try-catch para las exepciones del menú
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

                seleccionMenu = Integer.parseInt(seleccion.nextLine());//El dato de tipo String que ingresa el usuario pasa a ser de tipo Int para validarlo

                if (seleccionMenu >= 1 && seleccionMenu <= 5) { //Condición para validar que el usuario haya ingresado una opción correcta del menú

                    opcionCorrecta = true; //Si el usuario ingresó una opción válida opcionCorrecta es verdadera
                } else {
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Debe ingresar un número del 1 al 5");
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("");//Mensaje si la opción que muestra el usuario no es correcta
                    opcionCorrecta = false;//Si el usuario ingresó una opción inválida opcionCorrecta es falsa
                }
            } catch (NumberFormatException e) {//Atrapa una excepción si lo ques eingresó el usuario no es un número
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Debe introducir un número en el apartado del menú");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");//Mensaje en caso de que se detecte la exepción

            }
            Scanner leerDatosProducto = new Scanner(System.in);//Se inicializa el scanner leerDatosProducto para la recolección de datos en el switch
            switch (seleccionMenu) {//El switch va a trabajar de acuerdo a la selección del usuario para el menú

                case 1:
                    do {//Se crea un ciclo do-while para la solicitud de datos en el caso 1
                        String nuevoNombreProducto = solicitarNombreProducto(leerDatosProducto);//La variable de tipo String nuevoNombreProducto guarda el dato que retorna la función solicitarNombreProducto(leerDatosProducto)
                        double nuevoPrecioCorrecto = solicitarPrecioProducto(leerDatosProducto);//La variable de tipo double nuevoPrecioCorrecto guarda el dato que retorna la función solicitarPrecioProducto(leerDatosProducto)
                        int nuevaCantidadProducto = solicitarCantidadProducto(leerDatosProducto);//La variable de tipo int nuevaCantidadProducto guarda el dato que retorna la función solicitarCantidadProducto(leerDatosProducto)
                        Producto productoCreado = new Producto(nuevoNombreProducto, nuevoPrecioCorrecto, nuevaCantidadProducto);//Se crea una instancia de la clase Producto con atributos de la clase producto
                        ordenActual.agregarProducto(productoCreado);//Se invoca al método agregarProducto(productoCreado) de la clase Orden que tiene como para parámetro el objeto de la instacia de tipo producto
                        continuarOrden = ingresarOtroProducto(leerDatosProducto);//continuarOrden se iguala al lo que retorna la función ingresarOtroProducto(leerDatosProducto)

                    } while (continuarOrden);//El ciclo se va a repetir mientra continuarOrden sea verdadero
                    break;

                case 2:

                    solicitarNumOrden();//Se invoca la función solicitarNumOrden() para que el usuarion ingrese un número de orden
                    Date nuevaFecha = solicitarFecha(leerDatosProducto);//Se solicita la fecha y se guarda en la variable
                    //El detalle de la orden se asignó en la opción 1 
                    String nuevoNombreCliente = solicitarNombreCliente(leerDatosProducto);//Se solicita el nombre del cliente y se guarda en la variable
                    int descuentoAplicado = solicitarDescuento(leerDatosProducto);//Se solicita el descuento y se gurda en la variable
                    
                    //Se ingresan los datos recogidos a los atributos de Orden con ayuda de la instancia ordenActual
                    ordenActual.setFechaOrden(nuevaFecha);
                    ordenActual.setNombreCliente(nuevoNombreCliente);
                    ordenActual.setDescuento(descuentoAplicado);
                    
                    break;

                case 3:
                    preguntarNuevaOrden();//Método para preguntar al usuarion si desea ingresar otra orden
                    break;

                case 4:
                    mostrarDatos();//Método para mostrar los datos de las órdenes
                    break;

                case 5:
                    //En este caso finaliza el proceso y el programa termina
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
            }
            if (salir) {
                break;//Si salir es verdaro se aplica un break
            }

        } while (!opcionCorrecta || volverMenuPrincipal || !salir);//El ciclo se va a repetir mientras la opción no sea correcta, el usuario quiera volver al menú principal o no quiera salir de la aplicación
        seleccion.close();//Se cierra el scanner
    }
    
    //Se le pide al usuario que ingrese el número de la orden
    public static void solicitarNumOrden() {
        //Se definen e inicializan las variables del método
        boolean numeroValido = false;
        Scanner lecturaDatos = new Scanner(System.in);

        do {//Se crea un ciclo do-while que permite escribir y validar el número de la orden
            try {//Se crea un try-catch para las excepciones del número de orden
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Escriba el número de la orden");//Mensaje para que el usuario muestre la orden
                int nuevoNumOrden = Integer.parseInt(lecturaDatos.nextLine());//La variable de tipo String ingresada por el usuario se convierte en int y se guarda en la variable nuevoNumOrden
                ordenActual.crearNumOrden(nuevoNumOrden);//Se invoca el método crearNumOrden(nuevoNumOrden) de la clase Orden con ayuda de la objeto de tipo Orden ordenActual
                numeroValido = true;//numeroValido es verdadero en caso de que el usuario ingrese un número verdadero

            } catch (NumberFormatException e) {//Atrapa la excepción en caso que el usuario no ingrese un número
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Error, debe introducir un número para continuar");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");//Mesaje en caso de que haya una exepción en el dato que ingresó el usuario
            }
        } while (!numeroValido);//El ciclo se va a repetir mientra el número no se válido
    }

    public static void preguntarNuevaOrden() {
        Scanner leerOrdenNueva = new Scanner(System.in);
        String nuevaOrden = "";
        System.out.println("¿Desea agregar otra orden con otros productos? S/N");
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
        System.out.println(ordenActual.toString());
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