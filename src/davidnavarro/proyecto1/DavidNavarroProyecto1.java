//David Navarro Camacho
//Programaci�n intermedia
//III Cuatrimestre
//Proyecto 1
//Profesora: Adriana Rubio Escobar

package davidnavarro.proyecto1;

import java.text.ParseException;//Para trabajar la excepci�n de la fecha
import java.text.SimpleDateFormat;//Para asignar un formato espec�fico al momento de ingresar la fecha
import java.util.ArrayList;//Para trabajar con ArrayList
import java.util.Date;//Para trabajar con varibales de tipo Date
import java.util.Locale;//Para que permite y valide entradas en espa�ol de la fecha
import java.util.Scanner;//Para hacer uso de scanner y leer los datos

public class DavidNavarroProyecto1 {

    static boolean volverMenuPrincipal = false; //Variable para verificar si el usuario quiere volver al men�
    static ArrayList<Orden> ordenes = new ArrayList(); //Array list de tipo Orden para guardar �rdenes
    static Orden ordenActual = new Orden(); //Instancia para trabajar con la clase Orden

    public static void main(String[] args) {

        menuPrincipal();//LLamado del m�todo para el men� princip�l

    }
    
    //Se define el m�todo para el men� principal
    public static void menuPrincipal() {
        //Variables para el funcionamiento de la funci�n
        Scanner seleccion = new Scanner(System.in);
        boolean opcionCorrecta = false;
        boolean continuarOrden = false;
        boolean salir = false;
        int seleccionMenu = 0;

        do {//Se crea un ciclo do-while para el men� principal
            try {//Se inicia un try-catch para las exepciones del men�
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Opciones del restaurante, elija una opci�n:");
                System.out.println("");
                System.out.println("1. Creaci�n de productos");
                System.out.println("2. Toma de �rdenes");
                System.out.println("3. Ingresar otra orden");
                System.out.println("4. Reporte final ");
                System.out.println("5. Salir");

                seleccionMenu = Integer.parseInt(seleccion.nextLine());//El dato de tipo String que ingresa el usuario pasa a ser de tipo Int para validarlo

                if (seleccionMenu >= 1 && seleccionMenu <= 5) { //Condici�n para validar que el usuario haya ingresado una opci�n correcta del men�

                    opcionCorrecta = true; //Si el usuario ingres� una opci�n v�lida opcionCorrecta es verdadera
                } else {
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Debe ingresar un n�mero del 1 al 5");
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("");//Mensaje si la opci�n que muestra el usuario no es correcta
                    opcionCorrecta = false;//Si el usuario ingres� una opci�n inv�lida opcionCorrecta es falsa
                }
            } catch (NumberFormatException e) {//Atrapa una excepci�n si lo ques eingres� el usuario no es un n�mero
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Debe introducir un n�mero en el apartado del men�");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");//Mensaje en caso de que se detecte la exepci�n

            }
            Scanner leerDatosProducto = new Scanner(System.in);//Se inicializa el scanner leerDatosProducto para la recolecci�n de datos en el switch
            switch (seleccionMenu) {//El switch va a trabajar de acuerdo a la selecci�n del usuario para el men�

                case 1:
                    do {//Se crea un ciclo do-while para la solicitud de datos en el caso 1
                        String nuevoNombreProducto = solicitarNombreProducto(leerDatosProducto);//La variable de tipo String nuevoNombreProducto guarda el dato que retorna la funci�n solicitarNombreProducto(leerDatosProducto)
                        double nuevoPrecioCorrecto = solicitarPrecioProducto(leerDatosProducto);//La variable de tipo double nuevoPrecioCorrecto guarda el dato que retorna la funci�n solicitarPrecioProducto(leerDatosProducto)
                        int nuevaCantidadProducto = solicitarCantidadProducto(leerDatosProducto);//La variable de tipo int nuevaCantidadProducto guarda el dato que retorna la funci�n solicitarCantidadProducto(leerDatosProducto)
                        Producto productoCreado = new Producto(nuevoNombreProducto, nuevoPrecioCorrecto, nuevaCantidadProducto);//Se crea una instancia de la clase Producto con atributos de la clase producto
                        ordenActual.agregarProducto(productoCreado);//Se invoca al m�todo agregarProducto(productoCreado) de la clase Orden que tiene como para par�metro el objeto de la instacia de tipo producto
                        continuarOrden = ingresarOtroProducto(leerDatosProducto);//continuarOrden se iguala al lo que retorna la funci�n ingresarOtroProducto(leerDatosProducto)

                    } while (continuarOrden);//El ciclo se va a repetir mientra continuarOrden sea verdadero
                    break;

                case 2:

                    solicitarNumOrden();//Se invoca la funci�n solicitarNumOrden() para que el usuarion ingrese un n�mero de orden
                    Date nuevaFecha = solicitarFecha(leerDatosProducto);//Se solicita la fecha y se guarda en la variable
                    //El detalle de la orden se asign� en la opci�n 1 
                    String nuevoNombreCliente = solicitarNombreCliente(leerDatosProducto);//Se solicita el nombre del cliente y se guarda en la variable
                    int descuentoAplicado = solicitarDescuento(leerDatosProducto);//Se solicita el descuento y se gurda en la variable
                    
                    //Se ingresan los datos recogidos a los atributos de Orden con ayuda de la instancia ordenActual
                    ordenActual.setFechaOrden(nuevaFecha);
                    ordenActual.setNombreCliente(nuevoNombreCliente);
                    ordenActual.setDescuento(descuentoAplicado);
                    
                    break;

                case 3:
                    preguntarNuevaOrden();//M�todo para preguntar al usuarion si desea ingresar otra orden
                    break;

                case 4:
                    mostrarDatos();//M�todo para mostrar los datos de las �rdenes
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

        } while (!opcionCorrecta || volverMenuPrincipal || !salir);//El ciclo se va a repetir mientras la opci�n no sea correcta, el usuario quiera volver al men� principal o no quiera salir de la aplicaci�n
        seleccion.close();//Se cierra el scanner
    }
    
    //Se le pide al usuario que ingrese el n�mero de la orden
    public static void solicitarNumOrden() {
        //Se definen e inicializan las variables del m�todo
        boolean numeroValido = false;
        Scanner lecturaDatos = new Scanner(System.in);

        do {//Se crea un ciclo do-while que permite escribir y validar el n�mero de la orden
            try {//Se crea un try-catch para las excepciones del n�mero de orden
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Escriba el n�mero de la orden");//Mensaje para que el usuario muestre la orden
                int nuevoNumOrden = Integer.parseInt(lecturaDatos.nextLine());//La variable de tipo String ingresada por el usuario se convierte en int y se guarda en la variable nuevoNumOrden
                ordenActual.crearNumOrden(nuevoNumOrden);//Se invoca el m�todo crearNumOrden(nuevoNumOrden) de la clase Orden con ayuda de la objeto de tipo Orden ordenActual
                numeroValido = true;//numeroValido es verdadero en caso de que el usuario ingrese un n�mero verdadero

            } catch (NumberFormatException e) {//Atrapa la excepci�n en caso que el usuario no ingrese un n�mero
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Error, debe introducir un n�mero para continuar");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");//Mesaje en caso de que haya una exepci�n en el dato que ingres� el usuario
            }
        } while (!numeroValido);//El ciclo se va a repetir mientra el n�mero no se v�lido
    }
    
    //Se le pregunta al usuario si quiere ingresar otra orden nueva
    public static void preguntarNuevaOrden() {
        //Se definen e inicializan las variables del m�todo
        Scanner leerOrdenNueva = new Scanner(System.in);
        String nuevaOrden = "";
        
        System.out.println("�Desea agregar otra orden con otros productos? S/N");//Mensaje en caso de que el usuario quiera agregar otra orden con diferentes productos
        nuevaOrden = leerOrdenNueva.nextLine();//Se captura el dato ingresado por el usuario
        nuevaOrden = nuevaOrden.toUpperCase();//El dato ingresado por el usuario se convierte en may�sculas
        boolean eleccionValida = validarSoN(nuevaOrden);//Se define e inicializa la variable booleana eleccionValida que se iguala a lo que retorna el m�todo validarSoN(nuevaOrden)

        if (eleccionValida) {//Condici�n en caso de que la elecci�n sea v�lida

            ordenes.add(ordenActual);//Se a�ade al array list "ordenes" el objeto de tipo Orden "ordenActual" en ese momento
            //Para pruebas:
            //System.out.println("Tama�o");
            //System.out.println(ordenes.size());

            ordenActual = new Orden();//Despu�s del proceso "ordenActual" se inicializa como nuevo objeto de Orden
        }
    }
    
    //Se le pide al usuario que ingrese el nombre del nuevo producto
    public static String solicitarNombreProducto(Scanner leerNombre) {
        System.out.println("");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Ingrese el nombre del producto para crearlo");//Mensaje para solicitar el nombre del producto
        String nuevoNombreProducto = leerNombre.nextLine();//Se captura el dato uingresado por el usuario
        System.out.println("");

        return nuevoNombreProducto;//Retorna el nombre del producto ingresado
    }
    
    //Se le pide al usuario que ingrese el precio del nuevo producto
    public static double solicitarPrecioProducto(Scanner leerPrecio) {
        //Se definen e inicializan las variables del m�todo
        boolean precioCorrecto = false;
        double nuevoPrecioProducto = 0.0;

        do {//Ciclo do-while para que se ingrese y se valide el precio del producto
            try {//Try-catch para las excepciones del producto
                System.out.println("Ingrese el precio del producto");//Mensaje para ingresar precio
                String precioIngresado = leerPrecio.nextLine();//Se captura el dato
                nuevoPrecioProducto = Double.parseDouble(precioIngresado);//El dato capturado de tipo String se convierte a tipo double

                precioCorrecto = true;//Si no hay excepciones, el precio es correcto

            } catch (NumberFormatException e) {//Atrapa la excepci�n en caso de que el usuario haya ingresado un dato diferente de un n�mero
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Debe ingresar un n�mero para que el precio sea v�lido");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");//Mensaje en caso de que haya una exepci�n
            }
        } while (!precioCorrecto); //Ejecutarse mientras precioCorrecto est� NEGADO

        return nuevoPrecioProducto;//El m�todo retorna el precio del producto
    }
    
    //Se le pide al usuario que ingrese la cantidad del nuevo producto
    public static int solicitarCantidadProducto(Scanner leerCantidad) {
        //Se definen e inicializan las variables del m�todo
        boolean cantidadCorrecta = false;
        int nuevoCantidadProducto = 0;

        do {//Ciclo do-while para que se ingrese y se valide la cantidad del producto
            try {//Try-catch para las excepci�n de la cantidad
                System.out.println("");
                System.out.println("Ingrese la cantidad del producto");//Mensaje para que el usuario ingrese la cantidad del producto
                String cantidadIngresada = leerCantidad.nextLine();//Se captura el dato ingresado por el usuario y se guarda en la variable dde tipo String cantidadIngresada
                nuevoCantidadProducto = Integer.parseInt(cantidadIngresada);//El dato ingresado se convierte a tipo int

                cantidadCorrecta = true;//Si no hay exepciones la cantidad es correcta

            } catch (NumberFormatException e) {//Exepci�n en caso de que el usuario no haya ingresado un n�mero
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Debe ingresar un n�mero para que la cantidad sea v�lida");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");//Mensaje en caso de haya una exepci�n
            }
        } while (!cantidadCorrecta); //Ejecutarse mientras precioCorrecto est� NEGADO

        return nuevoCantidadProducto;//El m�todo retorna la nueva cantidad del producto
    }
    
    //Se le pide al usuario que ingrese la fecha
    public static Date solicitarFecha(Scanner leerFecha) {
        //Se define e inicializa la variable del m�todo
        boolean fechaValida = false;
        
        System.out.println("");
        System.out.println("Ingrese la fecha en la que crea la orden (Debe escribir en este formato dd/MMM/aaa) Por ejemplo: 2/feb/2024...");//Mensaje y explicaci�n para que el usuario ingrese la fecha con el formato esperado

        Date nuevaFecha = null;//Se define e inicializa la fecha en null

        do {//Ciclo do-while para que se ingrese y se valide la fecha
            String fechaIngresada = leerFecha.nextLine();//Se captura el dato

            SimpleDateFormat fechaFormateada = new SimpleDateFormat("dd/MMM/yyyy", Locale.forLanguageTag("es-ES"));//Se define e inicializa una fecha de tipo SimpleDateFormat para que se defina el formato esperato y que permita el ingreso de datos en idioma espa�ol
            fechaFormateada.setLenient(false);//El m�todo setLenient con el par�metro false permite que la fecha lance exepciones y se puede validar si hay alg�n error al momento de ingresar la fecha

            try {//try-catch para las exepciones de la fecha
                nuevaFecha = fechaFormateada.parse(fechaIngresada);//Se hace la conversi�n de la fecha de String a Date
                fechaValida = true;//Si no hay excepciones la fecha es v�lida
            } catch (ParseException errorParse) {//Captura la exepci�n en caso de que la fecha se ingrese con un formato diferente al defenido
                //Mensaje de error por defecto
                //System.out.println(errorParse);
                System.out.println("");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("La fecha es inv�lida, debe seguir el formato dd/MMM/aaaa");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");//Mensanje en caso de que la fecha sea inv�lida
            }
        } while (!fechaValida);//El ciclo se va a repetir mientras la fecha no sea v�lida

        return nuevaFecha;//El m�todo retorna la fecha
    }
    
    //Se le pide al usuario que ingrese el nombre del cliente
    public static String solicitarNombreCliente(Scanner leerNombreCliente) {
        System.out.println("");
        System.out.println("Ingrese el nombre del cliente");//Mensaje para que el usuario ingrese el nombre del cliente
        String nuevoNombreCliente = leerNombreCliente.nextLine();//Se captura el dato 
        System.out.println("");

        return nuevoNombreCliente;//El m�todo retorna el nombre del cliente
    }
    
    //Se le pide al usuario que ingrese el descuento
    public static int solicitarDescuento(Scanner leerDescuento) {
        //Se definen e inicializan las variables del m�todo
        boolean descuentoCorrecto = false;
        String nuevoDescuento;
        int descuentoAplicado = 0;

        do {//Ciclo do.while para que se ingrese y se valide el descuento
            System.out.println("Ingrese el c�gido de descuento: DSC5 = 5% / DSC10 = 10% / DSC15 = 15% / 0 = No se aplica descuento");//Mensaje y especificaciones para que el usuario ingrese el descuento
            String descuentoIngresado = leerDescuento.nextLine();//Se captura el dato
            nuevoDescuento = descuentoIngresado.toUpperCase();//El dato ingresado se convierte en may�sculas

            //Se aplica la condici�n para que los c�digos ingresados solo puedan ser DSC5, DSC10, DSC15, 0
            if (nuevoDescuento.equals("DSC5")) {//En el caso de que el c�digo sea uno de los anteriores descuentoCorrecto es verdadero y descuentoAplicado se iguala al valor que dependiento del c�digo 0, 5, 10, 15
                descuentoCorrecto = true;
                descuentoAplicado = 5;
            } else if (nuevoDescuento.equals("DSC10")) {//El m�todo .equals() compara las string
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
                System.out.println("No ingres� un descuento v�lido...");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("");//Mensaje en caso de que el descuento sea inv�lido
            }

        } while (!descuentoCorrecto);//El ciclo se va a repetir mientra el descuento no sea correcto

        return descuentoAplicado;//El m�todo retorna el descuento aplicado
    }
    
    //Se muestra el reporte final
    public static void mostrarDatos() {

        for (Orden orden : ordenes) {//Se recorre el array list de "Ordenes" e imprime el reporte final
            System.out.println(orden.toString());
        }
        System.out.println(ordenActual.toString());
    }
    
    //M�todo que valida si el usuario ingres� S o N
    public static boolean validarSoN(String eleccion) {
        //Se definen e inicializan las variables del m�todo
        boolean eleccionCorrecta = true;

        if (!eleccion.equals("S") && !eleccion.equals("N")) {//Condici�n que valida si el usuario ingresa algo diferente de S o N
            eleccionCorrecta = false;//En el caso de que ingrese algo de S o N la elecci�n no es correcta 
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Debe ingresar solo S o N");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("");//Mensaje en caso de que el dato no sea correcto

        } else {
            eleccionCorrecta = true;//Si el dato es v�lido, eleccionCorrecta = verdadero

        }
        return eleccionCorrecta;//El m�todo retorna la elecci�n del usuario
    }

    public static boolean ingresarOtroProducto(Scanner leerContinuar) {
        //Se definen e inicializan las variables del m�todo
        boolean respuestaValida = false;
        boolean continuar = false;
        String respuestaSN = "";

        do {//Ciclo do-while para que se ingrese y se valide la desici�n que crear otro producto
            System.out.println("");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("�Desea ingresar otro producto? S/N");//Mensaje en caso de crear otro producto
            String desicionAgregar = leerContinuar.nextLine();//Se captura el dato
            respuestaSN = desicionAgregar.toUpperCase();//El dato se convierte en may�sculas

            respuestaValida = validarSoN(respuestaSN);//RespuestaValida = al resultado booleano del m�todo validarSoN(respuestaSN)
        } while (!respuestaValida);//El ciclo se va a repetir mientras la respeusta no sea v�lida

        if (respuestaValida) {//Condici�n en caso de que la respuesta sea v�lida

            if (respuestaSN.equals("S")) {
                continuar = true;//Si la respuesta del usuario es igual a S, continuar es verdadero
            } else {
                continuar = false;
                volverMenuPrincipal = true;//De lo contrario, continuar es falso y volver�a al men�
            }
        } else {
            System.out.println("Solo se permite escribir S o N");//Mensaje en caso de que no ingrese S o N
        }

        return continuar; //El m�todo retorna el valor booleano continuar
    }
}