import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WorkArea extends JPanel implements MouseListener, MouseMotionListener, ActionListener
{
    private int x = -1;
    private int y = -1;
    private int option;
    DataSource d = DataSource.getInstance();

    public void startTimer() {
        Timer timer = new Timer(100, this);
        timer.start();
    }

    public WorkArea() {
        LineHandler line = new LineHandler();
        ClusterHandler cluster = new ClusterHandler();
        d.addObserver(line);
        d.addObserver(cluster);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paintComponent (Graphics g) {
        startTimer();

        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        super.setBackground(Color.WHITE);

        if (x != -1) {
            d.add(x, y);
            int size = DataSource.getInstance().getSize();
            for (int i = 0; i < size; i++) {
                Dot d = DataSource.getInstance().get(i);
                d.paint(g2, option);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void setOption(int i) {
        option = i;
    }

    @Override
    public void mouseReleased(MouseEvent e) { }
    public void mouseDragged(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { }

    @Override
    public void actionPerformed(ActionEvent e) { }
}
