package Shapes;

public abstract class Shape implements Comparable<Shape> {

    /**
     * @return The shape's height
     */
    public abstract double getHeight();

    /**
     * @return The value of the shape's area
     */
    public abstract double getBaseArea();

    /**
     * @return The value of the shape's volume
     */
    public abstract double getVolume();

    /**
     * 
     * @param other A shape object
     * @return The comparison of double height values according to the Shape object
     */
    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getHeight(), other.getHeight());
    }
}
