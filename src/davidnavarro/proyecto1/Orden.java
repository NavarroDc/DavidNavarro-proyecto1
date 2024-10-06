package davidnavarro.proyecto1;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//Atributos de la clase Orden
public class Orden {

    private Date fechaOrden;
    private ArrayList<Producto> detalleOrden = new ArrayList();//Productos de una orden en específico con sus atributos
    private String nombreCliente;
    private String numOrden;
    private int descuento;
    private double total;

    //Constructor sin parámetros
    public Orden() {

        this.numOrden = "";
        this.fechaOrden = null;
        this.nombreCliente = "";
        this.descuento = 0;
        this.total = 0.0;
    }

    //Constructor con parámetros
    public Orden(String numOrden, Date fechaOrden, String nombreCliente, int descuento, double total) {
        this.numOrden = numOrden;
        this.fechaOrden = fechaOrden;
        this.nombreCliente = nombreCliente;
        this.descuento = descuento;
        this.total = total;
    }

    //Getters y setters de la clase Orden
    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
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

    //Método toString() para mostrar el reporte final
    @Override
    public String toString() {       
        String factura = "";
        
        //Se utilizan los getters para mostrar el número de orden, la fecha y el nombre del cliente
        factura += "-----------------------------------------------------\n";
        factura += "Número de orden: " + this.getNumOrden() + "\n";
        factura += "Fecha de la orden:   " + this.getFechaOrden() + "\n";
        factura += "Nombre del cliente:   " + this.getNombreCliente() + "\n";
        factura += "Productos:\n";
        for(Producto productoRecorrido : this.detalleOrden){
            
            factura += productoRecorrido.mostrarProducto();//Se recorre detalleOrden y se muestran los datos por medio del método mostrarProducto()
        }
        //Se usa un get para mostrar el descuento y se invoncan métodos para mostrar el calcúlo del impuesto del servicio, del IVA, el subtotal y el total final
        factura += "Cálculo del servicio (10%): " + this.calculoServicio()+"\n";
        factura += "Cálculo del IVA (13%): " + this.calculoIVA()+"\n";
        factura += "Descuento: " + this.getDescuento()+"\n";
        factura += "Subtotal: " + this.primerTotal()+"\n";
        factura += "Total: " + this.totalFinal()+"\n";
        factura += "-----------------------------------------------------\n";

        //Formato de reporte final
        /* ----------------------------------------------------
        
            Numero de orden: ORD002
            Cliente:    Juan
            Fecha:     15 abr 2024

            Productos:

            5 x Donas:            $1500
            1 x Refresco:         $100
            1 x pizza:            $600

            Impuesto de servicio (10%):   $600
            Impuesto de I.V.A (13%):      $300
            SubTotal: $2200

            Total = $3100 
            ----------------------------------------------------*/
    
        return factura; //El método retorna la factura
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    //Método para crear el número de orden que se va a mostrar en el reporte final
    public void crearNumOrden(int numOrdenIngresado) {
        //Se define el inicializa la variable que se va a utlizar en el método
        String codigoOrden = "ORD";

        String codigoOrdenFinal = codigoOrden.concat(Integer.toString(numOrdenIngresado));//Se crea el cógido de la orden final (ORD####) concatenando la string "ORD" y la el int que se pasa pasa por parámetro
                                                                                          //Se realiza la conversión del número de orden ingresado para que sea una sola string
        this.numOrden = codigoOrdenFinal; //Se le asigna el código final al tributo de orden
    }

    //Método para agregar productos al array list de detalleOrden
    public void agregarProducto(Producto productoOrden) {
        this.detalleOrden.add(productoOrden);//Se agrega un producto al array list detalleOrden
    }
    
    //Método para obtener el resultado de la multiplicación precio * cantidad
    public double productoCantidadPrecio(){
        //Se define e inicializa la variable
        double precioCantidad = 0.0;
        
        for(Producto productoOrd : this.detalleOrden){
            
            precioCantidad = precioCantidad + (productoOrd.getPrecioProducto() * productoOrd.getCantidadProducto());
        }   //Se recorre el array list detalleOrden con un objeto de tipo producto para obtener el precio y la cantidad de los productos
            //Se realiza la multiplicación de precio * cantidad
            
        return precioCantidad; //El método retorna el resultado de precio * cantidad
    }

    //Calcula el impuesto del servicio (10%)
    public double calculoServicio() {

        double totalProducto = 0.0;
        
            totalProducto = productoCantidadPrecio() * 0.10;//Se realiza la multiplicació del resultado del método de productoCantidadPrecio() * 0.10 (impuesto del servicio 10%)
            
        return totalProducto; //Retorna el total del producto con el impuesto de servicio (10%)
    }

    //Calcula el impuesto del IVA (13%)
    public double calculoIVA() {

        double totalProducto = 0.0;
        
            totalProducto = productoCantidadPrecio() * 0.13;//Se realiza la multiplicació del resultado del método de productoCantidadPrecio() * 0.13 (impuesto del IVA 13%)
            
        return totalProducto;//Retorna el total del producto con el impuesto del IVA (13%)
    }
    
    //Cálculo del subtotal
    public double primerTotal() {
        double montoTotalProductos = 0.0;

        for (Producto productoOrd : this.detalleOrden) {
            montoTotalProductos = productoCantidadPrecio();//Se recorre el array list detalleOrden y se captura el dato resultante del método productoCantidadPrecio() 
                                                           //en la variable de tipo double montoTotalProductos
        }
        return montoTotalProductos + this.calculoIVA() + this.calculoServicio();//Retorna la suma de los impuestos (10%) y (13%) al total del productoCantidadPrecio()
    }
    
    //Cálculo del total final
    public double totalFinal() {
       
        double totalFinal = this.primerTotal() - (this.primerTotal() * ((this.descuento * 1.0) / 100.0)); //Se guarda en la variable totalFinal el resultado del subtotal menos el descuento
        System.out.println("");
        
        return totalFinal; //El método retorna el total final
    }
}
