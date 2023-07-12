import java.util.Observable;
import java.util.Observer;

public class LineHandler implements Observer {
    private void calculate() {
        int size = DataSource.getInstance().getSize();
        for (int i = 0; i < size; i++) {
            Dot d = DataSource.getInstance().get(i);
            // TODO: CALUCLATE LINE (x dist only)
            System.out.println("line");

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        calculate();
    }
}
