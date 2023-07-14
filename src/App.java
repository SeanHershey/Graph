import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener
{
    private boolean cluster = false;
    private boolean line = false;
    JPanel centerPanel = new WorkArea();
    private int option;

    public static void main(String[] args) throws Exception {
        App win = new App();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(800,600);
        win.setVisible(true);
    }

    public App() {
        super("Graph");

        // Toolbar (west)
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.GRAY);

        GridLayout grid = new GridLayout(10,1);
        JButton b1 = new JButton("Run");
        JCheckBox c1 = new JCheckBox("Cluster - K-means");
        JCheckBox c2 = new JCheckBox("Line - Nearest Neighbor");
        westPanel.setLayout(grid);
        westPanel.add(c1);
        westPanel.add(c2);
        westPanel.add(b1);
        
        // WorkArea
        centerPanel = new WorkArea();
        centerPanel.setBackground(Color.GRAY);

        // Add Panels  
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        // Listeners
        b1.addActionListener(this);
        c1.addActionListener(this);
        c2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Run")) {
            if (line && cluster) { option = 3; }
            else if (line) { option = 2; }
            else if (cluster) { option = 1; }
            else {option = 0;}
            ((WorkArea) centerPanel).setOption(option);
            repaint();
        }
        else if (e.getActionCommand().equals("Cluster - K-means")) {
            if (cluster) { cluster = false; }
            else { cluster = true; }
        }
        else if (e.getActionCommand().equals("Line - Nearest Neighbor")) {
            if (line) { line = false; }
            else { line = true; }
        }
    }

    // public int getOption() {
    //     if (line && cluster) {
    //         return 3;
    //     }
    //     else if (cluster) {
    //         return 2;
    //     }
    //     else if (line) {
    //         return 1;
    //     }
    //     return 0;
    // }
}