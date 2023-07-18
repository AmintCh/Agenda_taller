
package CONEXION;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    public Connection _conexion;   
    Statement _st;
    ResultSet _rs;
    String _user = "root";
    String _pass = "MyServer1";
    String _database = "taller";
    
    public Connection CrearConexion() {
        try {

            if (_conexion == null || _conexion.isClosed()) {              
                _conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+_database ,_user,_pass);
                _conexion.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                _conexion.setAutoCommit(false);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "No es posible conectar a la base datos ", JOptionPane.ERROR_MESSAGE);
        }
        return _conexion;
    }

    public ResultSet EjecutarConsulta(String query) {
        _st = null;
        _rs = null;
        CrearConexion();
        try {
            _st = _conexion.createStatement();
            _rs = _st.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al ejecutar consulta", JOptionPane.ERROR_MESSAGE);
            
        }
        return _rs;
    }

    public String EjecutarEscalar(String query) {
        _st = null;
        _rs = null;
        CrearConexion();
        try {
            _st = _conexion.createStatement();
            _rs = _st.executeQuery(query);
            if (_rs.next()) {
                return _rs.getString(1);
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al ejecutar consulta", JOptionPane.ERROR_MESSAGE);

        } finally {
            CerrarConexion();
        }
        return "";
    }

    public String Ejecutar(String query) {
        String resultado = "";
        try {
            CrearConexion();
            _conexion.setAutoCommit(false);
            Statement st = _conexion.createStatement();
            st.execute(query);
            _conexion.commit();
        } catch (SQLException ex) {
            resultado = ex.toString();
            JOptionPane.showMessageDialog(null, ex, "Error al intentar conectar a la base de datos", JOptionPane.ERROR_MESSAGE);
            try {
                _conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
             
                CerrarConexion();
        }
        return resultado;
    }

   
    public void CerrarConexion() {
        try {
            if (_conexion != null || !_conexion.isClosed()) {
                _conexion.close();
                System.gc();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al cerrar la Base de Datos", JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
