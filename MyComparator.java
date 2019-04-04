import java.util.Comparator;

public class MyComparator implements Comparator<Kulig> {
    @Override
    public int compare(Kulig o1, Kulig o2) {
        if(o1.getDriver().compareTo(o2.getDriver()) > 0)
            return 1;
        if(o1.getDriver().compareTo(o2.getDriver()) < 0)
            return -1;
        else
        {
            if(o1.getHorseName().compareTo(o2.getHorseName()) > 0)
                return 1;
            if (o1.getHorseName().compareTo(o2.getHorseName()) < 0)
                return -1;
        }
        return 0;
    }
}
