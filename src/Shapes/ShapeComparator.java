package Shapes;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    private String sortingCriteria;

    public ShapeComparator(String sortingCriteria) {
        this.sortingCriteria = sortingCriteria;
    }

    @Override
    public int compare(Shape shape1, Shape shape2) {

        switch (sortingCriteria) {
            case "h":
                return Double.compare(shape1.getHeight(), shape2.getHeight());
            case "v":
                return Double.compare(shape1.getVolume(), shape2.getVolume());
            case "a":
                return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
            default:
                throw new IllegalArgumentException("Invalid sorting criteria: " + sortingCriteria);
        }
    }
}
