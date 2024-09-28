package davidnavarro.proyecto1;

public class Producto {
    
    private String nombreProducto;
    private double precioProducto;

    public Producto() {
       this.nombreProducto = "";
       this.precioProducto = 0.0;
    }

    public Producto(String nombreProducto, double precioProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }  
}
