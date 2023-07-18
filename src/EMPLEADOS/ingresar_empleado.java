
package EMPLEADOS;

public class ingresar_empleado extends datos_empleado {

    public ingresar_empleado(int codigo_empleado, String nombre, String apellido, int telefono, boolean estado, double salario) {
        this.setCodigo_empleado(codigo_empleado);
        this.setNombre(nombre);
        this.setApelido(apellido);
        this.setTelefono(telefono);
        this.setEstado(estado);
        this.setSalario(salario);
    }  
}
