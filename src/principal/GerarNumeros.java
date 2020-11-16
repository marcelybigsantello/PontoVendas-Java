package principal; 

/**
 *
 * @author Marcely
 */
public class GerarNumeros {
    private int cont = 1;
    private int dado;
    private String numero = "";
    
    public void gerar (int dado){
        this.dado = dado;
        
        if ((this.dado >= 10000) || (this.dado < 100000)){
            int novoNumero = this.dado + cont;
            numero = "" + novoNumero;
        }
        else if ((this.dado >= 1000) || (this.dado < 10000)){
            int novoNumero = this.dado + cont;
            numero = "0" + novoNumero;
        }
        else if ((this.dado >= 100) || (this.dado < 1000)){
            int novoNumero = this.dado + cont;
            numero = "00" + novoNumero;
        }
        else if ((this.dado >= 10) || (this.dado < 100)){
            int novoNumero = this.dado + cont;
            numero = "000" + novoNumero;
        }
        else if (this.dado >= 9){
            int novoNumero = this.dado + cont;
            numero = "0000" + novoNumero;
        }
    }
    
    public String serie(){
        return this.numero;
    }
    
}
