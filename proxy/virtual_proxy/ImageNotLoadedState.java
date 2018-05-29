import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class ImageNotLoadedState implements Icon {
    public int getIconWidth() {
        return 800;
    }

    public int getIconHeight() {
        return 600;
    }

    public void paintIcon(final Component c, Graphics g, int x, int y) {
        g.drawString("loading CD cover, please wait...", x + 300, y + 190);
    }
}