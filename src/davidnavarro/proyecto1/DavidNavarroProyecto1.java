package davidnavarro.proyecto1;

import java.util.Date;

public class DavidNavarroProyecto1 {
    
    public static void main(String[] args) {
        Producto p1 = new Producto("pizza", 500);
        Producto p2 = new Producto("hamburguesa", 600);
        Date fechaNueva = new Date();
        
        Orden ord = new Orden(1, fechaNueva, "Marcos", 5 , 0.0);
        
        ord.agregarProducto(p1);
        ord.agregarProducto(p2);
        ord.imprimirFactura();
        
    }
    
}
