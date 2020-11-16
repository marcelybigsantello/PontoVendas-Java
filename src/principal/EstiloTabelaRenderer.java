package principal;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Marcely
 */
public class EstiloTabelaRenderer extends DefaultTableCellRenderer{
    //Classe criada com o objetivo de formatar as linhas da tabela de registros mostradas nos forms
    private Component componente;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        this.setHorizontalAlignment(0);
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        
        if (row%2 == 0){
            componente.setForeground(Color.BLACK);
            componente.setBackground(new Color(232, 232, 232));
        } else {
            componente.setForeground(Color.BLACK);
            componente.setBackground(Color.LIGHT_GRAY);
        }
        
        if (isSelected == true){
            componente.setForeground(Color.WHITE);
            componente.setBackground(new Color(28, 134, 238));
        }
        return componente;
        
    }
    
}
