package Shapes;

public class TriangularPrism extends Shape {
    private double height;
    private double edgeLength;

    public TriangularPrism(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getBaseArea() {
        return (Math.sqrt(3) / 4.0) * edgeLength * edgeLength; // Area of an equilateral triangle
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
