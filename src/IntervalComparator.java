import java.util.Comparator;

public class IntervalComparator implements Comparator<Interval> {

    // -ve means i1 is smaller
    // +ve means i1 is greater
    // 0 means both are equal
    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
        //return new Integer(i1.start).compareTo(new Integer(i2.start));

    }
}