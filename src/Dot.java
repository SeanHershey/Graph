import java.awt.Color;
import java.awt.Graphics2D;

public class Dot {
    private int x;
    private int y;
    private Color color = Color.BLACK;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void paint(Graphics2D g2) {
        g2.setColor(color);
        g2.fillOval(x, y, 10, 10);
    }

}