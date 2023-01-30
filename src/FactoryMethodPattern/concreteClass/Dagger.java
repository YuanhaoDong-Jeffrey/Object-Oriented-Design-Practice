package FactoryMethodPattern.concreteClass;

import FactoryMethodPattern.abstractClass.Weapon;

public class Dagger extends Weapon {
    @Override
    public void attack() {
        System.out.println("Dagger attack");
    }
}
