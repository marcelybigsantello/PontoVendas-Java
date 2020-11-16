package usuarios;

import ConexaoBD.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.GerarCodigos;

/**
 *
 * @author Marcely
 */
public class UsuariosDAO {

    static Conectar cc = new Conectar();
    static Connection cn = cc.connection();
    static PreparedStatement ps;

    //Métodos úteis
    public static String REGISTRAR = "INSERT INTO usuarios(codigo_us,nome_us, sexo_us, tipo_us, senha) VALUES (?, ?, ?, ?, ?);";

    public static String LISTAR = "SELECT * FROM usuarios ORDER BY codigo_us ASC";

    public static String SELECIONAR = "SELECT nome_us, tipo_us FROM usuarios WHERE codigo_us = ?";

    public static String ATUALIZAR = "UPDATE usuarios SET nome_us=?, sexo_us=?, tipo_us=?, senha=? WHERE codigo_us=?";

    public static String EXCLUIR = "DELETE FROM usuarios WHERE codigo_us = ?";

    public static String EXCLUIR_TUDO = "DELETE FROM usuarios";

    public static void gerarId() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";

        String sql = "SELECT MAX(codigo_us) FROM USUARIOS";

        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                usuarios.FrmUsuarios.txtCodigo.setText("1");
            } else {
                int qtd = c.length();
                char r1 = c.charAt(0);
                num = "" + r1;
                if (qtd > 1) {
                    char r2 = c.charAt(1);
                    num = "" + r1 + r2;
                }
                if (qtd > 2) {
                    char r2 = c.charAt(1);
                    char r3 = c.charAt(2);
                    num = "" + r1 + r2 + r3;
                }
                /*char r3 = c.charAt(2);
                 char r4 = c.charAt(3);*/
                //num = "" + r1;
                j = Integer.parseInt(num);
                GerarCodigos gen = new GerarCodigos();
                gen.gerar(j);
                usuarios.FrmUsuarios.txtCodigo.setText(gen.serie());
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public static void listarUsuario(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) usuarios.FrmUsuarios.tabelaUsuarios.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = null;
        if (busca.equals("")) {
            sql = LISTAR;
        } else {
            sql = "SELECT * FROM usuarios WHERE (codigo_us ='" + busca + "' "
                    + "OR nome_us like'" + busca + "%') "
                    + "ORDER BY codigo_us ASC";
        }

        int numColunas = 5;
        String dados[] = new String[numColunas];

        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dados[0] = rs.getString("codigo_us");
                dados[1] = rs.getString("nome_us");
                dados[2] = rs.getString("sexo_us");
                dados[3] = rs.getString("tipo_us");
                dados[4] = rs.getString("senha");

                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* public static void listarCliente(String busca){
        DefaultTableModel modelo = (DefaultTableModel) usuarios.FrmUsuarios.tabelaUsuarios.getModel();
        
        while (modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }
        
        String sql = null;
        if (busca.equals("")){
            sql = LISTAR;
        }
        else {
            sql = "SELECT nome_us FROM usuarios WHERE (nome_us='"+ busca+"')"
                    + "ORDER BY nome_us ASC";
        }
        int numeroColunas = 1;
        String dados [] = new String[numeroColunas];
        Statement st;
        
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                dados[1] = rs.getString("nome_us");
                
                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na listagem cliente: "+ex.getMessage());
        }
    }*/
    
    
    public static int cadastrar(Usuarios usuario) {
        int ret = 0;
        String sql = REGISTRAR;
        /*int numColunas = 5;
         String dados[] = new String[numColunas];*/
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, usuario.getCodigo());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getSexo());
            ps.setString(4, usuario.getTipo());
            ps.setString(5, usuario.getSenha());
            /*dados[0] = String.valueOf(usuario.getCodigo());
             dados[1] = usuario.getNome();
             dados[2] = usuario.getSexo();
             dados[3] = usuario.getTipo();
             dados[4] = usuario.getSenha();
             String query= "INSERT INTO usuarios(codigo_us, nome_us, sexo_us, tipo_us, senha) " 
             + "VALUES ("+Integer.parseInt(dados[0])+",'"+dados[1]+"','"+dados[2]+"','"+dados[3]+"','"+dados[4]+"');";*/
            ret = ps.executeUpdate();
            //cn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.toString());
        }
        System.out.println(sql);
        return ret;
    }

    public static int atualizar(Usuarios us) {
        int ret = 0;
        String sql = ATUALIZAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, us.getNome());
            ps.setString(2, us.getSexo());
            ps.setString(3, us.getTipo());
            ps.setString(4, us.getSenha());
            ps.setInt(5, us.getCodigo());

            ret = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            String erro = ex.toString();
            System.out.println("Erro: " + erro);
        }
        //System.out.println(sql);
        return ret;
    }

    public static int excluir(int id) {
        int ret = 0;
        String sql = EXCLUIR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.toString());
        }
        //System.out.println(sql);
        return ret;
    }

    public static int excluirTudo() {
        int ret = 0;
        String sql = EXCLUIR_TUDO;

        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.toString());
        }
        System.out.println(sql);
        return ret;

    }
}
