/**
 * @author Kushal Saini
 * @author Pelvain Dhanda
 * @author Nimrat Brar
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rectangle {

    int height;
    int width;
    int x;
    int y;
    Color color;

    public Rectangle(int x, int y, int w, int h, Color color) {
        this.height = h;
        this.width = w;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void drawRect(Graphics2D g2d) {
        Rectangle2D.Double rect = new Rectangle2D.Double(x,y,width,height);
        g2d.setColor(color);
        g2d.fill(rect);
    }
}
