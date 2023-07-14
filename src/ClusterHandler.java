import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class ClusterHandler implements Observer {

    private void calculate() {
        int size = DataSource.getInstance().getSize();
        for (int i = 0; i < size; i++) {
            Dot d = DataSource.getInstance().get(i);
            // TODO: CALCULATE CLUSTER
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        calculate();
    }
}