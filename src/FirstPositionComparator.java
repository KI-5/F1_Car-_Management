import java.io.Serializable;
import java.util.Comparator;

public class FirstPositionComparator implements Comparator<Formula1Driver>, Serializable {
    /**
     *
     * @param d1 first first position
     * @param d2 second first position
     * @return return biggest first position
     */
    @Override
    public int compare(Formula1Driver d1, Formula1Driver d2) {

        if (d1.getFirstPositions()< d2.getFirstPositions()){
            //check highest value
            return 1;
        }
        else if (d1.getFirstPositions()>d2.getFirstPositions()){
            //check lowest value
            return -1;
        }
        else {
            return 0;
        }
    }
}
