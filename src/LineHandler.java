import java.util.Observable;
import java.util.Observer;

public class LineHandler implements Observer {
    
    private void calculate() {
        int size = DataSource.getInstance().getSize();
        for (int i = 1; i < size; i++) {
            Dot dA = DataSource.getInstance().get(i);
            Dot dB = DataSource.getInstance().get(i-1);
            // TODO: CALUCLATE LINE (x dist only)
            int distanceX = dB.getX()-dA.getX();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        calculate();
    }
}
