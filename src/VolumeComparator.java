import java.util.Comparator;

public class VolumeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getVolume(), shape2.getVolume());
    }
}
