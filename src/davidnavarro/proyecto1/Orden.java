package davidnavarro.proyecto1;

import java.util.ArrayList;
import java.util.Date;

//Atributoss de la clase Orden
public class Orden {
    private int numOrden;
    private Date fechaOrden;
    private ArrayList<String> detalleOrden = new ArrayList();
    private String nombreCliente;
    private double descuento;
    private double total;

    //Constructor sin par�metros
    public Orden() {
        
        this.numOrden = 0;
        this.fechaOrden = null;
        this.nombreCliente = "";
        this.descuento = 0.0;
        this.total = 0.0;
    }

    public Orden(int numOrden, Date fechaOrden, String nombreCliente, double descuento, double total) {
        this.numOrden = numOrden;
        this.fechaOrden = fechaOrden;
        this.nombreCliente = nombreCliente;
        this.descuento = descuento;
        this.total = total;
    }

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

    public ArrayList<String> getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(ArrayList<String> detalleOrden) {
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
    
    
   
}

