package viagogo;


import java.util.Comparator;
import javafx.util.Pair;


public class ListComparator implements Comparator<Pair<Integer, Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {

        return o1.getValue() - o2.getValue();

    }


}
