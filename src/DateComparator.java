import java.io.Serializable;
import java.util.Comparator;

public class DateComparator implements Comparator <RaceCompleted>, Serializable {
    //comparator to compare race dates

    @Override
    public int compare(RaceCompleted d1, RaceCompleted d2) {
        return d1.getRaceDate().compareTo(d2.getRaceDate());
        //return oldest date
    }
}