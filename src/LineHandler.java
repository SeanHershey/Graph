import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.awt.Color;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LineHandler implements Observer {
    private void calculate() {
        int size = DataSource.getInstance().getSize();
        LinkedList<Dot> doneDot = new LinkedList<Dot>();
        List<Dot> dots = DataSource.getInstance().getList();

        for(int i = 0; i < size - 1; i++){
            Dot minXdot = null;
            for(Dot dot: dots){
                if (!doneDot.contains(dot))
                {
                    if(minXdot == null){
                        minXdot = dot;
                    }
                    if(dot.getX() < minXdot.getX()){
                        minXdot = dot;
                    }
                }
            }
            doneDot.add(minXdot);

            Dot secondMinXdot = null;
            for(Dot dot: dots){
                if (!doneDot.contains(dot))
                {
                    if(secondMinXdot == null){
                        secondMinXdot = dot;
                    }
                    if(dot.getX() < secondMinXdot.getX()){
                        secondMinXdot = dot;
                    }
                }
            }
            minXdot.setLine(secondMinXdot);
        }
        

        // for(int i = 1; i < size -1; i++){
        //     Dot curDot = DataSource.getInstance().get(i);
        //     if(curDot.getX() < curMinX && !doneDot.contains(curDot)){
        //         minXdot = curDot;
        //     }
        // }





        // for (int i = 1; i < size; i++) {
        //     Dot dA = DataSource.getInstance().get(i);
        //     Dot minDot = null;
        //     int minDistance = Integer.MAX_VALUE;

        //     for(int j = 0; j < i; j++){
        //         Dot dB = DataSource.getInstance().get(j);
        //         int distanceX = dB.getX()-dA.getX();
        //         if (distanceX < minDistance){
        //             minDistance = distanceX;
        //             minDot = dB;
        //         }
        //     }
        //     if(minDot != null){
        //         dA.setLine(minDot);
        //     }
        // }
    }

    @Override
    public void update(Observable o, Object arg) {
        calculate();
    }
}
