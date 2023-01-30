package FactoryMethodPattern.concreteFactory;

import FactoryMethodPattern.abstractClass.Weapon;
import FactoryMethodPattern.abstractFactory.WeaponFactory;
import FactoryMethodPattern.concreteClass.Gun;

public class GunFactory extends WeaponFactory {
    @Override
    public Weapon get() {
        return new Gun();
    }
}
