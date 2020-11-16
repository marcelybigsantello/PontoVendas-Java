package vendas;

import ConexaoBD.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import principal.GerarNumeros;

/**
 *
 * @author Marcely
 */
public class VendasDAO {

    static Conectar cc = new Conectar();
    static Connection cn = cc.connection();
    static PreparedStatement ps;
    
    /*Nova versão do Listar: 
        select v.codigo_venda, v.total_venda, v.data_venda, u.nome_us
        from vendas v inner join usuarios u
        where v.id_usuario = u.codigo_us;
    */

    public static String REGISTRAR = "INSERT INTO vendas(codigo_venda, total_venda, data_venda, id_usuario) VALUES (?, ?, ?, ?)";

    public static String LISTAR = "SELECT v.codigo_venda, v.total_venda, v.data_venda, u.nome_us "
            + "FROM vendas v inner join usuarios u "
            + "ON (v.id_usuario = u.codigo_us) "
            + "ORDER BY v.codigo_venda ASC";

    public static String EXCLUIR = "DELETE FROM vendas WHERE codigo_venda = ?";

    public static String EXCLUIR_TUDO = "DELETE FROM vendas";

    public static int cadastrar(Vendas venda) {
        int ret = 0;
        String sql = REGISTRAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, venda.getCodigo_venda());
            ps.setFloat(2, venda.getTotal_venda());
            ps.setString(3, venda.getData_venda());
            ps.setInt(4, venda.getId_usuario());

            ret = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.toString());
        }
        return ret;
    }

    public static void listarVendasCliente(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) vendas.FrmVendas.tabela.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        String sql = null;
        if (busca.equals("")) {
            sql = LISTAR;
        } else {
            sql = "SELECT v.codigo_venda, v.total_venda, v.data_venda, u.nome_us "
                    + "FROM vendas v inner join usuarios u "
                    + "ON (v.id_usuario = u.codigo_us) "
                    + "WHERE (v.codigo_venda LIKE '" + busca + "%' OR u.nome_us LIKE '" + busca + "%') "
                    + "ORDER BY v.codigo_venda ASC";
            
            /*
                SELECT v.codigo_venda, v.total_venda, v.data_venda, u.nome_us 
                FROM vendas v inner join usuarios u 
                ON (v.id_usuario = u.codigo_us) 
                WHERE (v.codigo_venda LIKE '1%' OR u.nome_us LIKE '%') 
                ORDER BY v.codigo_venda ASC
            */
            /*SELECT * FROM pontovendas.vendas WHERE (codigo_venda LIKE '00%' 
            OR data_venda LIKE '%') 
            ORDER BY codigo_venda ASC;*/
        }
        String dados[] = new String[4];

        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                dados[0] = rs.getString("codigo_venda");
                dados[1] = rs.getString("total_venda");
                dados[2] = rs.getString("data_venda");
                dados[3] = rs.getString("nome_us");
                
                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.toString());
        }
    }
    
    public static void listarPorData(String busca){
        DefaultTableModel modelo = (DefaultTableModel) vendas.FrmVendas.tabela.getModel();
        
        while (modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }
        String sql = null;
        if (busca.equals("")){
            sql = LISTAR;
        } else {
            sql = "SELECT v.codigo_venda, v.total_venda, v.data_venda, u.nome_us" +
                    "FROM vendas v inner join usuarios u" +
                    "ON (v.id_usuario = u.codigo_us)" +
                    "WHERE (data_venda ='" + busca + "')" +
                    "ORDER BY v.codigo_venda ASC";
        }
        
        String resultados[] = new String[4];
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                resultados[0] = rs.getString("codigo_venda");
                resultados[1] = rs.getString("total_venda");
                resultados[2] = rs.getString("data_venda");
                resultados[3] = rs.getString("nome_us");
                
                modelo.addRow(resultados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: "+ex.getMessage());
        }
    }

    public static int excluir(int codigo) {
        int ret = 0;
        String sql = EXCLUIR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);

            ret = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na exclusão individual: " + ex.toString());
        }
        System.out.println(sql);
        return ret;
    }

    public static int excluirTudo() {
        int ret = 0;
        String sql = EXCLUIR_TUDO;

        try {
            ps = cn.prepareStatement(sql);
            ret = ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na exclusão total: " + ex.getMessage());
        }
        return ret;
    }

    public static void gerarNumeros() {
        int j;
        int cont = 1;
        String numero = "";
        String c = "";

        String sql = "SELECT MAX(codigo_venda) FROM vendas";

        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                c = rs.getString(1);
            }
            
            if (c == null){
                vendas.FrmCaixa.txtNumeroVenda.setText("000001");
            } else {
                j = Integer.parseInt(c);
                GerarNumeros gerador = new GerarNumeros();
                gerador.gerar(j);
                vendas.FrmCaixa.txtNumeroVenda.setText(gerador.serie());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao gerar número de venda: "+ex.toString());
        }
    }
}
