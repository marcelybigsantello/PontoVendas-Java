
package usuarios;

/**
 *
 * @author Marcely
 */
public class Usuarios {
    
    private Integer codigo;
    private String nome;
    private String sexo;
    private String tipoUsuario;
    private String senha;
    
    public Usuarios(){
        this.codigo = 0;
        this.nome = "";
        this.sexo = "";
        this.tipoUsuario = "";
        this.senha = "";
    }
    
    public Usuarios(Integer cod, String nome, String sexo, String tipo, String senha){
        this.codigo = cod;
        this.nome = nome;
        this.sexo = sexo;
        this.tipoUsuario = tipo;
        this.senha = senha;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(Integer cod){
        this.codigo = cod;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nm){
        this.nome = nm;
    }
    
    public String getSexo(){
        return this.sexo;
    }
    
    public void setSexo(String sx){
        this.sexo = sx;
    }
    
    public String getTipo(){
        return this.tipoUsuario;
    }
    
    public void setTipo(String tipo){
        this.tipoUsuario = tipo;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
}
