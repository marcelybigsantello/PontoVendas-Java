package produtos;

/**
 *
 * @author Marcely
 */
public class Produtos {
    
    private Integer codigo;
    private String tipo;
    private String nome;
    private float valor;
    
    public Produtos(){
        this.codigo = 0;
        this.tipo = "";
        this.nome = "";
        this.valor = 0.0f;
    }
    
    public Produtos(Integer cod, String tipo, String nome, float preco){
        this.codigo = cod;
        this.tipo = tipo;
        this.nome = nome;
        this.valor = preco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
