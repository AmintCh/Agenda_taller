
package VEHICULOS;

public class ingreso_datos_vehiculo extends datos_vehiculo {

    public ingreso_datos_vehiculo(int codigo_vehiculo, String marca, String serie, String placa, int cilindraje, String propietario) {
        this.setCodigo_vehiculo(codigo_vehiculo);
        this.setMarca(marca);
        this.setSerie(serie);
        this.setPlaca(placa);
        this.setCilindraje(cilindraje);
        this.setPropietario(propietario);
    }
    
    
}
