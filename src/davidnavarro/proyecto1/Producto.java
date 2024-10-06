package davidnavarro.proyecto1;

public class Producto {
    
    //Atributos de la clase Producto
    private String nombreProducto;
    private double precioProducto;
    private int cantidadProducto;

    //Constructor sin parámetros
    public Producto() {
        this.nombreProducto = "";
        this.precioProducto = 0.0;
        this.cantidadProducto = 0;
    }

    //Constructor con parámetros
    public Producto(String nombreProducto, double precioProducto, int cantidadProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
    }
    
    public String mostrarProducto(){
        String detalleProducto = "";
        
        detalleProducto += Integer.toString(this.getCantidadProducto()) + " X " //Se guarda en la variable detalleProducto por medio de los getters la concatenación de la cantidad del producto convertidad de String a int,
                                                                                //el nombre del producto y el resultaldo del precio * cantidad de modo que se visualice así: 2 X Pizza: 7500
                + this.getNombreProducto() + ": "
                +Double.toString(this.getPrecioProducto() * this.getCantidadProducto()) + "\n";
        
        return detalleProducto;
    }
    
    //Getters y setters de los atributos de la clase Productos
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

