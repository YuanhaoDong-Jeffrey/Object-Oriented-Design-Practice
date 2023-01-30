package FactoryMethodPattern.concreteFactory;

import FactoryMethodPattern.abstractClass.Weapon;
import FactoryMethodPattern.abstractFactory.WeaponFactory;
import FactoryMethodPattern.concreteClass.Dagger;

public class DaggerFactory extends WeaponFactory {
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
