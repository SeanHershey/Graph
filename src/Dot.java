import java.awt.Color;
import java.awt.Graphics2D;

public class Dot {
    private int x;
    private int y;
    private Color color = Color.BLACK;  
    private int lineX;
    private int lineY;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void setLine(Dot d) {
        lineX = d.getX();
        lineY = d.getY();
    }

    public void paint(Graphics2D g2, int option) {
        // option 1:cluster, 2:line, 3:both
        g2.setColor(Color.BLACK);
        if (option == 1 || option == 3) {
            g2.setColor(color);
        }
        g2.fillOval(x, y, 10, 10);
        if (option > 2) {
            g2.setColor(Color.ORANGE);
            g2.drawLine(x, y, lineX, lineY);
        }
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

}
