import javax.swing.*;
import java.awt.*;

public class MyPanel extends JComponent {
    private ImageIcon icon;
    public MyPanel(){
        icon = new ImageIcon("./src/Resource/steve.png");
    }
    public MyPanel(ImageIcon icon){
        this.icon=icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        repaint();
    }

    public void paint(Graphics g){
        g.drawImage(icon.getImage(),0,0, this.getWidth(), this.getHeight(), null);
    }
}
