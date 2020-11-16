package principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Marcely
 */
public class EstiloTabelaHeader implements TableCellRenderer{
    //Classe criada com o objetivo de formatar o cabeçalho da tabela de registros mostradas nos forms
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int row, int column) {
        JComponent jcomponent = null;
        
        if (value instanceof String){
            jcomponent = new JLabel((String) " " + value);
            ((JLabel)jcomponent).setHorizontalAlignment(SwingConstants.LEFT);
            ((JLabel)jcomponent).setSize(30, jcomponent.getWidth());
            ((JLabel)jcomponent).setPreferredSize(new Dimension(3, jcomponent.getWidth()) );
        }
        
        jcomponent.setEnabled(true);
        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jcomponent.setOpaque(true);
        jcomponent.setBackground(new Color(0, 103, 139) );
        jcomponent.setForeground(Color.WHITE);
        jcomponent.setFont(new Font("Arial", Font.BOLD, 12));
        jcomponent.setToolTipText("Column Nº "+(column+1));
        
        return jcomponent;
    }
    
}
