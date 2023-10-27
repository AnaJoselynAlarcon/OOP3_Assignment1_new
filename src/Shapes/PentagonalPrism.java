package Shapes;

public class PentagonalPrism extends Shape {
    private double height;
    private double edgeLength;

    public PentagonalPrism(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getBaseArea() {
        return (5.0 * edgeLength * edgeLength * Math.tan(Math.toRadians(54))) / 4.0; // Area of a regular pentagon
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
