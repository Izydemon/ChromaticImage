package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author legol
 */
public class ImagePanel extends JPanel {
    
    private BufferedImage image;
    private Image img;
    
    private boolean imageSet = false;
    
    private boolean R = true;
    private boolean G = true;
    private boolean B = true;
    
    public ImagePanel(){
        super();
    }
    
    public void AddImage(String imageDir){
        try {
            image = ImageIO.read(new File(imageDir));
            imageSet = true;
        } catch (IOException ex) {
            System.out.println("Couldn't load image");
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(imageSet){
            BufferedImage rgbImage = UtilsPractica5.seleccionarComponentes(image, R, G, B);
            img = rgbImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(img, 0, 0, this);
        }
    }
    
    public void SetAllChannels(){
        R = true;
        G = true;
        B = true;
        
        this.update(this.getGraphics());
    }
    
    public void ChangeChannelR(boolean r){
        R = r;
        this.update(this.getGraphics());
    }
    
    public void ChangeChannelG(boolean g){
        G = g;
        this.update(this.getGraphics());
    }
    
    public void ChangeChannelB(boolean b){
        B = b;
        this.update(this.getGraphics());
    }
    
}
