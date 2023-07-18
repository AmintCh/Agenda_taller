package AGENDA;
import CONEXION.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
public class Agenda {
    public void llenaEmpleado(JComboBox comboEmpleado) throws SQLException{
        Conexion con = new Conexion();
        ResultSet res;
        int linea=0;
        String query = "select codigo_empleado,nombre,apellido, telefono,estado,salario from empleado order by codigo_empleado "; 
        res = con.EjecutarConsulta(query);
     
        while (res.next()){    
            comboEmpleado.addItem(res.getInt(1) + "-" + res.getString(2) + " " + res.getString(3));
            linea++;
        }
        con.CerrarConexion();
    }
    
    public void llenaVehiculo(JComboBox comboVehiculo) throws SQLException{
        Conexion con = new Conexion();
        ResultSet res;
        int linea=0;
        String query = "select codigo_vehiculo, numero_placa,propietario,marca from vehiculo order by codigo_vehiculo "; 
        res = con.EjecutarConsulta(query);
     
        while (res.next()){    
            comboVehiculo.addItem(res.getInt(1) + "-" + res.getString(4) + "/" + res.getString(2) + "/" + res.getString(3));
            linea++;
        }
        con.CerrarConexion();
    }
    
    public void llenaServicio(JComboBox comboServicio) throws SQLException{
        Conexion con = new Conexion();
        ResultSet res;
        int linea=0;
        String query = "select codigo_servicio, descripcion from servicio order by codigo_servicio "; 
        res = con.EjecutarConsulta(query);
     
        while (res.next()){    
            comboServicio.addItem(res.getInt(1) + "-" + res.getString(2));
            linea++;
        }
        con.CerrarConexion();
    }

    private boolean validaRestriccion (String Campo,String valor, String Fecha, String Hora){
        boolean Resultado = false;
        String vExiste;
        String query;
        Conexion con = new Conexion(); 
        query = "select count(codigo_turno) from Agenda where codigo_" + Campo + " = " +valor+ " and fecha = '"+Fecha+"' and hora = '"+ Hora +"'";
        vExiste=con.EjecutarEscalar(query);
        if (vExiste.equals("0")){
            Resultado = true;
        }
        return Resultado;
    }
    
    public int guardarTurno(String Vehiculo, String Servicio,String Empleado, String Fecha, String Hora){
        String query;
        String vCodigo;
        
        if(validaRestriccion("vehiculo",Vehiculo,Fecha,Hora)){
            if(validaRestriccion("empleado",Empleado,Fecha,Hora)){
                Conexion con = new Conexion(); 
                query = "select ifnull(max(codigo_turno),0)+1 from agenda";
                vCodigo=con.EjecutarEscalar(query);
                query = "insert into agenda (codigo_turno,codigo_vehiculo,codigo_servicio,codigo_empleado,hora,fecha)" +
                        "values(" + vCodigo + "," +Vehiculo + "," + Servicio + ", " + Empleado + ",'" + Hora + "','" + Fecha + "')";
                System.out.println(query);
                con.Ejecutar(query);
                con.CerrarConexion();
                return 0;
            }else{return 1;}
        }else{return 2;}
    }
    
    public String devuelveCodigo(String valor){
        int posicion = valor.indexOf("-");
        String codigo = valor.substring(0,posicion);
        return codigo.trim();
    }
}
