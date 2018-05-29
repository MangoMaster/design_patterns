import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageLoadedState implements Icon {
    ImageIcon imageIcon;
    URL imageUrl;
    boolean retrieving = false;

    public ImageLoadedState(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getIconWidth() {
        return imageIcon.getIconWidth();
    }

    public int getIconHeight() {
        return imageIcon.getIconHeight();
    }

    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if (!retrieving) {
            retrieving = true;
            Thread retrievalThread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        imageIcon = new ImageIcon(imageUrl, "CD cover");
                        c.repaint();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            retrievalThread.start();
        } else {
            imageIcon.paintIcon(c, g, x, y);
        }
    }

}