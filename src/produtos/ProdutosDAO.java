package produtos;

import ConexaoBD.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import principal.GerarCodigos;

/**
 *
 * @author Marcely
 */
public class ProdutosDAO {

    static Conectar cc = new Conectar();
    static Connection cn = cc.connection();
    static PreparedStatement ps;

    public static String REGISTRAR = "INSERT INTO produtos(codigo_prod, tipo_prod, nome_prod, valor_prod) VALUES (?, ?, ?, ?)";

    public static String LISTAR = "SELECT * FROM produtos ORDER BY codigo_prod ASC";

    public static String SELECIONAR = "SELECT nome_prod, tipo_prod FROM produtos WHERE codigo_prod = ?";

    public static String ATUALIZAR = "UPDATE produtos SET tipo_prod=?, nome_prod=?, valor_prod=? WHERE codigo_prod=?";

    public static String EXCLUIR = "DELETE FROM produtos WHERE codigo_prod = ?";

    public static String EXCLUIR_TUDO = "DELETE FROM produtos";

    public static void gerarID() {
        int j;
        int cont = 1;
        String numero = "";
        String c = "";

        String sql = "SELECT MAX(codigo_prod) FROM produtos";

        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                produtos.FrmProdutos.txtCodigo.setText("1");
            } else {
                int qtd = c.length();
                char n1 = c.charAt(0);
                numero = "" + n1;
                if (qtd > 1) {
                    char n2 = c.charAt(1);
                    numero = "" + n1 + n2;
                }
                if (qtd > 2) {
                    char n2 = c.charAt(1);
                    char n3 = c.charAt(2);
                    numero = "" + n1 + n2 + n3;
                }
                j = Integer.parseInt(numero);
                GerarCodigos gerador = new GerarCodigos();
                gerador.gerar(j);
                produtos.FrmProdutos.txtCodigo.setText(gerador.serie());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro geração de IDs: " + ex.toString());
        }
    }

    public static void listar(String busca) {

        DefaultTableModel modelo = (DefaultTableModel) produtos.FrmProdutos.tabela.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = null;

        if (busca.equals("")) {
            sql = LISTAR;
        } else {
            sql = "SELECT * from produtos WHERE (tipo_prod LIKE '" + busca + "%' "
                    + "OR nome_prod LIKE '" + busca + "%') "
                    + "ORDER BY codigo_prod ASC";
        }

        int numColunas = 4;
        String dados[] = new String[numColunas];
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                dados[0] = rs.getString("codigo_prod");
                dados[1] = rs.getString("tipo_prod");
                dados[2] = rs.getString("nome_prod");
                dados[3] = rs.getString("valor_prod");

                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public static void listarCategoria(String busca) {

        DefaultTableModel modelo = (DefaultTableModel) produtos.FrmListaProd.tabela.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = null;

        if (busca.equals("")) {
            sql = LISTAR;
        } else {
            sql = "SELECT * from produtos WHERE (tipo_prod LIKE '" + busca + "%' "
                    + "OR nome_prod LIKE '" + busca + "%' OR codigo_prod LIKE'"+busca+"%') "
                    + "ORDER BY codigo_prod ASC";
        }

        int numColunas = 4;
        String dados[] = new String[numColunas];
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                dados[0] = rs.getString("codigo_prod");
                dados[1] = rs.getString("tipo_prod");
                dados[2] = rs.getString("nome_prod");
                dados[3] = rs.getString("valor_prod");

                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
    public static int cadastrar(Produtos produto) {
        int ret = 0;
        //sempre quando houver uma atualização no BD, devo utilizar o método prepareStatement
        //Quando houver uma consulta ou listagem de registros, devo utilizar o método createStatement
        String sql = REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getTipo());
            ps.setString(3, produto.getNome());
            ps.setFloat(4, produto.getValor());

            ret = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.toString());
        }
        return ret;
    }

    public static int atualizar(Produtos prod) {
        int ret = 0;
        String sql = ATUALIZAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, prod.getTipo());
            ps.setString(2, prod.getNome());
            ps.setFloat(3, prod.getValor());
            ps.setInt(4, prod.getCodigo());

            ret = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql);
        return ret;
    }

    public static int excluir(int cod) {
        int retorno = 0;
        String sql = EXCLUIR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            retorno = ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.toString());
        }
        System.out.println(sql);
        return retorno;
    }

    public static int excluirTudo() {
        int ret = 0;
        String sql = EXCLUIR_TUDO;
        try {
            ps = cn.prepareStatement(sql);
            ret = ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na exclusão total: " + ex.toString());
        }
        System.out.println(sql);
        return ret;

    }
    
    public static boolean isNumber(String num){
        try{
            if (Integer.parseInt(num) > 0 ){
                return true;
            } else {
                return false;
            }    
        } catch (NumberFormatException ex){
            return false;
        }
    }
}
