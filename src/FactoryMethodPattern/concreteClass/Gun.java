package FactoryMethodPattern.concreteClass;

import FactoryMethodPattern.abstractClass.Weapon;

public class Gun extends Weapon {
    @Override
    public void attack() {
        System.out.println("Gun attack!");
    }
}
