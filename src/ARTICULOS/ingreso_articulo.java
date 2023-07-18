
package ARTICULOS;

public class ingreso_articulo extends datos_articulo {

    public ingreso_articulo(int codigo_articulo, String nombre_articulo, double precio, int existencia) {
        this.setCodigo_articulo(codigo_articulo);
        this.setNombre_articulo(nombre_articulo);
        this.setPrecio(precio);
        this.setExistencia(existencia);
    }
    
}
