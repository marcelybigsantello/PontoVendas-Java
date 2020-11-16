package principal;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Marcely Biguzzi Santello
 */
public class Carregador extends JDesktopPane{
    Image img = new ImageIcon(getClass().getResource("/imagens/principal/pvGrande.png")).getImage();
    @Override
    public void paintChildren(Graphics g){
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        super.paintChildren(g);
    }
}
