package davidnavarro.proyecto1;

import java.util.ArrayList;
import java.util.Date;

//Atributos de la clase Orden
public class Orden {
    private int numOrden;
    private Date fechaOrden;
    private ArrayList<Producto> detalleOrden = new ArrayList();
    private String nombreCliente;
    private double descuento;
    private double total;

    //Constructor sin parámetros
    public Orden() {
        
        this.numOrden = 0;
        this.fechaOrden = null;
        this.nombreCliente = "";
        this.descuento = 0.0;
        this.total = 0.0;
    }
    
    //Constructor con parámetros
    public Orden(int numOrden, Date fechaOrden, String nombreCliente, double descuento, double total) {
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

    public void setDescuento(double descuento) {
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
}

