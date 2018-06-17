import java.util.ArrayList;
import java.util.ListIterator;

public class PancakeHouseIterator implements Iterator<MenuItem> {
    ArrayList<MenuItem> items;
    ListIterator<MenuItem> iterator;

    public PancakeHouseIterator(ArrayList<MenuItem> items) {
        this.items = items;
        this.iterator = items.listIterator();
    }

    public MenuItem next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}