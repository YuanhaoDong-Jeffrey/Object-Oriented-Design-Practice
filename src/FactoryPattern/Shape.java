package FactoryPattern;

public interface Shape {
    void drow(int size);
}

class Rectangle implements Shape {
    @Override
    public void drow(int size) {
        System.out.println("Rectangle with size being " + String.valueOf(size));
    }
}

class Square implements Shape {
    @Override
    public void drow(int size) {
        System.out.println("Square with the size being " + String.valueOf(size));
    }
}

class Circle implements Shape {
    @Override
    public void drow(int size) {
        System.out.println("Circle with the size being " + String.valueOf(size));
    }
}