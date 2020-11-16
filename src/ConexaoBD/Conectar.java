package ConexaoBD;

//import com.mysql.jdbc.Connection; --> biblioteca foi descontinuada (deprecated)
//informações do banco de dados no site umbler: 
//usuário: mabiguzzi e senha: marcelypontovendas
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcely
 */
public class Conectar {
    
    Connection conect = null;
    
    //Conexão Local
    public Connection connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/pontovendas?zeroDateTimeBehavior=convertToNull", "root", "a281168");
        } catch (ClassNotFoundException | SQLException ex ) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados: " + ex);
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conect;
    }
    
    //Conexão Remota
    /*public Connection connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://mysql380.umbler.com:41890/pontovendas", "mabiguzzi", "marcelypontovendas");
        } catch (ClassNotFoundException | SQLException ex ) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados: " + ex);
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conect;
    }*/
}
