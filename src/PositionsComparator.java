import java.io.Serializable;
import java.util.Comparator;

public class PositionsComparator implements Comparator<Formula1Driver>, Serializable {
    //comparator to compare points in descending order

    @Override
    public int compare(Formula1Driver d1, Formula1Driver d2) {
        if (d1.getNoOfPoints()>d2.getNoOfPoints()) {
            //compare points
            return -1;
        }
        else if (d1.getNoOfPoints()<d2.getNoOfPoints()){
            //compare points
            return 1;
        }
        else if (d1.getFirstPositions()< d2.getFirstPositions()){
            //compare first positions
            return 1;
        }
        else if (d1.getFirstPositions()>d2.getFirstPositions()){
            //compare first positions
            return -1;
        }
        else{
            return 0;
        }
    }
}
