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

    
    @Override
    public String toString() {
        //return "\n"+"\n"+"\n Reporte de la orden\n" + "\n Número de orden: " + numOrden + "\n Fecha de la orden: " + fechaOrden + "\n Nombre del cliente: " + nombreCliente + "\n Descuento: " + descuento + "\n Total de la compra: " + total;
                  
        String factura = "";
        
        factura += "-----------------------------------------------------\n";
        factura += "Número de orden: " + this.getNumOrden() + "\n";
        factura += "Fecha de la orden:   " + this.getFechaOrden() + "\n";
        factura += "Nombre del cliente:   " + this.getNombreCliente() + "\n";
        factura += "Productos:\n";
        for(Producto productoRecorrido : this.detalleOrden){
            
            factura += productoRecorrido.mostrarProducto();
        }
        factura += "Cálculo del servicio (10%): " + this.calculoServicio();
        factura += "Cálculo del IVA (13%): " + this.calculoIVA();
        factura += "Descuento: " + this.getDescuento();
        factura += "Subtotal: " + this.primerTotal();
        factura += "Subtotal: " + this.getTotal();
        factura += "-----------------------------------------------------\n";

        
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
    
        return factura;
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void crearNumOrden(int numOrdenIngresado) {
        String codigoOrden = "ORD";

        String codigoOrdenFinal = codigoOrden.concat(Integer.toString(numOrdenIngresado));

        this.numOrden = codigoOrdenFinal;
    }

    public void agregarProducto(Producto productoOrden) {
        this.detalleOrden.add(productoOrden);
    }
    
    public double productoCantidadPrecio(){
        
        double precioCantidad = 0.0;
        
        for(Producto productoOrd : this.detalleOrden){
            
            precioCantidad = precioCantidad + (productoOrd.getPrecioProducto() * productoOrd.getCantidadProducto());
        }
        return precioCantidad;
    }

    public double calculoServicio() {

        double totalProducto = 0.0;
        
            totalProducto = productoCantidadPrecio() * 0.10;
            
        return totalProducto;
    }

    public double calculoIVA() {

        double totalProducto = 0.0;
        
            totalProducto = productoCantidadPrecio() * 0.13;
            
        return totalProducto;
    }

    public double primerTotal() {
        double montoTotalProductos = 0.0;

        for (Producto productoOrd : this.detalleOrden) {
            montoTotalProductos = productoCantidadPrecio();
        }
        return montoTotalProductos + this.calculoIVA() + this.calculoServicio();
    }

    public double totalFinal() {
       
        double totalFinal = this.primerTotal() - (this.primerTotal() * (this.descuento / 100));
        

        return totalFinal;
    }
}
