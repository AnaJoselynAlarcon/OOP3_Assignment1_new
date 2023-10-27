package Shapes;

public class OctagonalPrism extends Shape {
    private double height;
    private double edgeLength;

    public OctagonalPrism(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getBaseArea() {
        return 2.0 * (1.0 + Math.sqrt(2)) * edgeLength * edgeLength; // Area of a regular octagon
    }

    @Override
    public double getVolume() {
        return (getBaseArea() * height) / 4.0;
    }
}
