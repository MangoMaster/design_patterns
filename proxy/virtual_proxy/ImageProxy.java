import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/*public class ImageProxy implements Icon {
    ImageIcon imageIcon;
    URL imageUrl;
    Thread retrievalThread;
    boolean retrieving = false;

    public ImageProxy(URL url) {
        imageUrl = url;
    }

    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }

    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            g.drawString("loading CD cover, please wait...", x + 300, y + 190);
            if (!retrieving) {
                retrieving = true;
                retrievalThread = new Thread(new Runnable() {

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
            }
        }
    }
}*/

public class ImageProxy implements Icon {
    private Icon imageNotLoadedState;
    private Icon imageLoadedState;

    private Icon state = imageNotLoadedState;

    public ImageProxy(URL imageUrl) {
        imageNotLoadedState = new ImageNotLoadedState();
        imageLoadedState = new ImageLoadedState(imageUrl);
    }

    public int getIconWidth() {
        return state.getIconWidth();
    }

    public int getIconHeight() {
        return state.getIconHeight();
    }

    public void paintIcon(final Component c, Graphics g, int x, int y) {
        state.paintIcon(c, g, x, y);
        if (state == imageNotLoadedState) {
            state = imageLoadedState;
        }
    }
}