package vendas;

/**
 *
 * @author Marcely
 */
public class Vendas {
    private Integer codigo_venda;
    private float total_venda;
    private String data_venda;
    private Integer id_usuario;
    
    public Vendas(){
        this.codigo_venda = 0;
        this.total_venda = 0.0f;
        this.data_venda = "";
        this.id_usuario = 0;
    }
    
    public Vendas(Integer codigo, float total, String data, Integer idUsuario){
        this.codigo_venda = codigo;
        this.total_venda = total;
        this.data_venda = data;
        this.id_usuario = idUsuario;
    }

    public Integer getCodigo_venda() {
        return codigo_venda;
    }

    public void setCodigo_venda(Integer codigo_venda) {
        this.codigo_venda = codigo_venda;
    }

    public float getTotal_venda() {
        return total_venda;
    }

    public void setTotal_venda(float total_venda) {
        this.total_venda = total_venda;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
