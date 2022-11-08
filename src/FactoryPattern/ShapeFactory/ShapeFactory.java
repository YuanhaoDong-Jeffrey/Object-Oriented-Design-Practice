package FactoryPattern.ShapeFactory;

public class ShapeFactory {
    /**
     * The getShape takes a String and will return a shape
     * This factory class is used to separate the construction of the objects
     * and the usage of the objects, so that the users' code won't be affected
     * when we extend more shapes
     * @param shapeType
     * @return
     */
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }

        return null;
    }
}
