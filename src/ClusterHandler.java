import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ClusterHandler implements Observer {
    List<Dot> dots = DataSource.getInstance().getList();

    private void calculate() {
        int size = DataSource.getInstance().getSize();
        List<Dot> blue = new ArrayList<Dot>();
        List<Dot> orange = new ArrayList<Dot>();

        if (size == 1) {
            blue.add(dots.get(0));
        }
        else if (size == 2) {
            blue.add(dots.get(0));
            orange.add(dots.get(1));
        }
        else if (size >= 2) {
            int choice = (int)(Math.random()*size);
            Dot centriod_2 = new Dot(dots.get(choice).getX(), dots.get(choice).getY());
            choice = (int)(Math.random()*size);
            Dot centriod_1 = new Dot(dots.get(choice).getX(), dots.get(choice).getY());

            for (int i = 0; i < size; i++) {
                double dist_1 = Math.sqrt(Math.pow(dots.get(i).getX() - centriod_1.getX(), 2) +
                    Math.pow(dots.get(i).getY() - centriod_1.getY(), 2));

                double dist_2 = Math.sqrt(Math.pow(dots.get(i).getX() - centriod_2.getX(), 2) +
                    Math.pow(dots.get(i).getY() - centriod_2.getY(), 2));

                if (dist_1 > dist_2) {
                    blue.add(dots.get(i));
                }
                else {
                    orange.add(dots.get(i));
                }
            }
        }
        for(int i = 0; i < blue.size(); i++){
            blue.get(i).setColor(Color.BLUE);
        }
        for(int i = 0; i < orange.size(); i++){
            orange.get(i).setColor(Color.ORANGE);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        calculate();
    }
}