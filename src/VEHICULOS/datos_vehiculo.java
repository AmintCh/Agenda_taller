
package VEHICULOS;
public class datos_vehiculo {
    private int codigo_vehiculo;    
    private String placa;
    private String marca;
    private String serie;
    private int cilindraje;
    private String propietario;

    public int getCodigo_vehiculo() {
        return codigo_vehiculo;
    }

    public void setCodigo_vehiculo(int codigo_vehiculo) {
        this.codigo_vehiculo = codigo_vehiculo;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
