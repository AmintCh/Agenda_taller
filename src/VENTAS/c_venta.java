
package VENTAS;
import CONEXION.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class c_venta {  
    public String Consultar_no_factura(){
       String query;
       String vCodigo;
       Conexion con = new Conexion(); 
       query = "select ifnull(max(No_factura),0)+1 from factura";
       vCodigo=con.EjecutarEscalar(query);
       con.CerrarConexion();
       return vCodigo;
    }
    
    public void llenaArticulo(JComboBox comoboArticulo) throws SQLException{
        Conexion con = new Conexion();
        ResultSet res;
        int linea=0;
        String query = "select codigo, articulo from articulo order by codigo "; 
        res = con.EjecutarConsulta(query);
     
        while (res.next()){    
            comoboArticulo.addItem(res.getInt(1) + "-" + res.getString(2));
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
    
    
    public void Guardar_factura(String No_factura, String Nit, String Nombre, String Direccion ){
        String query;
     
       Conexion con = new Conexion(); 
       query = " insert into factura(No_factura, Nit, Nombre_cliente, Direccion) ";
       query +="values("+No_factura+",'"+Nit+"','"+Nombre+"','"+Direccion+"')";

       con.Ejecutar(query);
       con.CerrarConexion();
        
    }
    
     public void Guardar_detalleFactura(String No_factura, String codigo_articulo, String codigo_servicio, String cantidad, String Precio ){
        String query;
     
       Conexion con = new Conexion(); 
       query = " insert into detalle_factura(No_factura, codigo_articulo, codigo_servicio, cantidad, Precio) ";
       query +="values("+No_factura+","+codigo_articulo+","+codigo_servicio+","+cantidad+","+Precio+")";

       con.Ejecutar(query);
       con.CerrarConexion();
        
    }
    
      public String devuelveCodigo(String valor){
          try{
             int posicion = valor.indexOf("-");
              String codigo = valor.substring(0,posicion);
              return codigo.trim();
          }
           catch(Exception e){
               return "null";
     }
    }
         
}
