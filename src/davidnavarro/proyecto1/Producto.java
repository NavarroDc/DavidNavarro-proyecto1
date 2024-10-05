package davidnavarro.proyecto1;

public class Producto {

    private String nombreProducto;
    private double precioProducto;
    private int cantidadProducto;

    public Producto() {
        this.nombreProducto = "";
        this.precioProducto = 0.0;
        this.cantidadProducto = 0;
    }

    public Producto(String nombreProducto, double precioProducto, int cantidadProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
    }
    
    public String mostrarProducto(){
        String detalleProducto = "";
        
        detalleProducto += Integer.toString(this.getCantidadProducto()) + " X " 
                + this.getNombreProducto() + ": "
                +Double.toString(this.getPrecioProducto() * this.getCantidadProducto()) + "\n";
        
        return detalleProducto;
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

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

}
//Añadir atributo cantidad a Producto
