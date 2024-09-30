package davidnavarro.proyecto1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//Atributos de la clase Orden
public class Orden {

    private int numOrden;
    private Date fechaOrden;
    private ArrayList<Producto> detalleOrden = new ArrayList();
    private String nombreCliente;
    private int descuento;
    private double total;

    //Constructor sin parámetros
    public Orden() {

        this.numOrden = 0;
        this.fechaOrden = null;
        this.nombreCliente = "";
        this.descuento = 0;
        this.total = 0.0;
    }

    //Constructor con parámetros
    public Orden(int numOrden, Date fechaOrden, String nombreCliente, int descuento, double total) {
        this.numOrden = numOrden;
        this.fechaOrden = fechaOrden;
        this.nombreCliente = nombreCliente;
        this.descuento = descuento;
        this.total = total;
    }

    //Getters y setters de la clase Orden
    public int getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(int numOrden) {
        this.numOrden = numOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public ArrayList<Producto> getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(ArrayList<Producto> detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orden{" + "numOrden=" + numOrden + ", fechaOrden=" + fechaOrden + ", detalleOrden=" + detalleOrden + ", nombreCliente=" + nombreCliente + ", descuento=" + descuento + ", total=" + total + '}';
    }
    //------------------------------------------------------------------------------------------------------------------------------------------
    
    public void menuPrincipal(){
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
    
    public void agregarProducto(Producto productoOrden) {
        this.detalleOrden.add(productoOrden);
    }

    public double calculoServicio() {

        double totalProducto = 0.0;

        for (Producto productoOrd : this.detalleOrden) {
            totalProducto = totalProducto + productoOrd.getPrecioProducto();
        }
        return totalProducto * 0.10;
    }

    public double calculoIVA() {

        double totalProducto = 0.0;

        for (Producto productoOrd : this.detalleOrden) {
            totalProducto = totalProducto + productoOrd.getPrecioProducto();
        }
        return totalProducto * 0.13;
    }

    public double total() {
        double montoTotalProductos = 0.0;

        for (Producto productoOrd : this.detalleOrden) {
            montoTotalProductos = montoTotalProductos + productoOrd.getPrecioProducto();
        }
        return montoTotalProductos + this.calculoIVA() + this.calculoServicio();
    }

    public double totalFinal() {
        double totalFinal = this.total() - (this.total() * (this.descuento / 100));

        return totalFinal;
    }

    public void imprimirFactura() {
        for (Producto verProducto : this.detalleOrden) {

            System.out.println("-" + verProducto.getNombreProducto() + "-" + verProducto.getPrecioProducto());

        }
    }
}
