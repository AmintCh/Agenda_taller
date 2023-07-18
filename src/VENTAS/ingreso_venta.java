
package VENTAS;
public class ingreso_venta extends descripcion_venta {

    public ingreso_venta(int codigo_venta, int codigo_articulo, int cantidad, double precio ) {
        this.setCodigo_venta(codigo_venta);
        this.setCodigo_articulo(codigo_articulo);
        this.setCantidad(cantidad);
        this.setPrecio(precio);
        
    }
}
