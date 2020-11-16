package principal;

import ConexaoBD.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcely
 */
public class Sessao {
    public static Integer codigo;
    public static String usuario;
    protected static String senha;
    
    public Sessao(){
        
    }
    
    public Sessao(Integer id, String usuario, String senha){
        this.codigo = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public static Integer getCodigo() {
        return codigo;
    }

    public static void setCodigo(Integer codigo) {
        Sessao.codigo = codigo;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Sessao.usuario = usuario;
    }
   
    //Inicialização da conexão com o BD
    static Conectar conexao = new Conectar();
    static Connection conn = conexao.connection();
            
    public static String logarUsuario(String nome, String senha){
        String dado = null;
        String nomeCliente = null;
        
        try{
            //Inicialização do banco de dados que permite associar com o resultado da consulta query anterior
            //É necessário criar um objeto Statement porque apenas ele consegue executar uma query
            //Para executar uma query, é necessário armazenar o seu resultado em uma variável do tipo ResultSet
            String sql = "SELECT nome_us FROM pontovendas.usuarios WHERE nome_us = '" +nome+ "' ";
            Statement st = conn.createStatement();            
            ResultSet rs = st.executeQuery(sql);
            
            //Se encontrar algum registro no BD
            if(rs.first()){
                String sql1 = "SELECT senha FROM pontovendas.usuarios WHERE senha = '"+senha+"' ";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                
                if (rs1.first()){
                    String sql2 = "SELECT tipo_us FROM pontovendas.usuarios WHERE nome_us = '" + nome + "' "
                            + "AND senha = '" + senha + "' ";
                    Statement st2 = conn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql2);
                    
                    while(rs2.next()){
                        //ResultSet retorna o resultado da query e o getString() captura a String que ele encontrou
                        //Dois tipos de usuário: admin e padrão
                        dado = rs2.getString(1);
                    }
                    if (dado.equals("ADMINISTRADOR")) {
                        String sql3 = "SELECT nome_us FROM pontovendas.usuarios WHERE nome_us = '" + nome + "'";
                        try {
                            Statement st3;
                            st3 = conn.createStatement();
                            ResultSet rs3 = st3.executeQuery(sql3);

                            while (rs3.next()) {
                                nomeCliente = rs3.getString(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        //Logo o usuário tem perfil padrão
                        String sql4 = "SELECT nome_us FROM pontovendas.usuarios WHERE nome_us ='" + nome + "'";
                        try {
                            Statement st4;
                            st4 = conn.createStatement();
                            ResultSet rs4 = st4.executeQuery(sql4);

                            while (rs4.next()) {
                                nomeCliente = rs4.getString(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.\nDigite-a novamente!",
                            "Login", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "O usuário não existe no banco de dados",
                        "Login", JOptionPane.ERROR_MESSAGE);
            }        
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados de login");
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomeCliente;
    }
    
    public static String armazenarPerfil(String nome){
        String retorno = null;
        
        try {
            String query = "SELECT nome_us FROM pontovendas.usuarios WHERE nome_us = '" +nome+ "' ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.first()){
                String query2 = "SELECT tipo_us FROM pontovendas.usuarios WHERE nome_us = '" + nome + "' ";                            
                Statement st2 = conn.createStatement();
                ResultSet rs2 = st2.executeQuery(query2);
                
                while(rs2.next()){
                    retorno = rs2.getString(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
    public static int armazenarIdUsuario(String nome){
        int retorno = 0;
        String query = "SELECT * FROM pontovendas.usuarios WHERE nome_us = '"+nome+"';";
        
        //SELECT * FROM pontovendas.usuarios WHERE nome_us = 'Marcely';
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.first()){
                String sql1 = "SELECT codigo_us FROM usuarios WHERE nome_us = '"+usuario+"';";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                
                if (rs1.first()){
                    //armazena o código identificador do usuário logado
                    retorno = rs1.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
}