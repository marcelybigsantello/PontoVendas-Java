package principal;

/**
 *
 * @author Marcely
 */
public class GerarCodigos {
    private int dado;
    private int cont = 1; 
    private String cod = "";
    
    public void gerar (int dado){
        this.dado = dado;
        
        if ((this.dado >=1000) || (this.dado < 10000)){
            int can = cont+this.dado;
            cod = "" + can;
        }
        if ((this.dado >=100) || (this.dado<1000)){
            int can = cont+this.dado;
            cod = "0" + can;
        }
        if ((this.dado>=9) ||(this.dado<100)){
            int can = cont+this.dado;
            cod = "00" + can;
        }
        if (this.dado < 9) {
            int can = cont+this.dado;
            cod = "000" + can;
        }
    }
    
    public String serie(){
        return this.cod;
    }

}
