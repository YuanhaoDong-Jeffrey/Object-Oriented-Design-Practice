package FactoryPattern;

public class FactoryDemo {
    private static final ShapeFactory shapeFactory = new ShapeFactory();

    public static void main(String[] args) {
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.drow(10);

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.drow(20);

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.drow(30);
    }
}
