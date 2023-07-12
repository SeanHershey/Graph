import java.util.Observable;
import java.util.Stack;

public class DataSource extends Observable {
    private static DataSource instance;
    Stack<Dot> points = new Stack<Dot>();

    private DataSource() { }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public void add(int x, int y) {
        points.push(new Dot(x, y)); 
        setChanged();
        notifyObservers();
    }

    public Dot get(int i) {
        return points.get(i);
    }

    public int getSize() {
        return points.size();
    }
}
