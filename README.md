# Object-Oriented-Design-Practice

## Builder pattern
1. The constructor of User is private, therefore it only has class visibility.
2. The UserBuilder's "setter" methods return this reference, therefore we can chain the method calls.


## Factory pattern
1. Separate instance/object creation logic from its usage (Creation: a concrete shape, Usage: draw())
2. Easier to extend the instance creation logic(extend the factory only)
3. Provide chances to have different object allocation strategies(e.g. what if we want to reuse shape objects -> object pool pattern)


## Adapter Pattern
1. The high level interface may have many methods to be implemented.
2. Use an abstract class adapter to implement the interface, with the core method leave abstract.
3. In this case, the concrete class will only need to worry about the core method implementation, instead of all the other methods leave blank.

## Singleton Pattern
1. The Singleton pattern is a design pattern that is used to ensure that a class has only one instance, while providing a global access point to that instance. This is useful in cases where a single instance of a class must control the action throughout the execution of the program
2. The steps to create a singleton class: Make the instance private, make the constructor private, and provide a public getInstance() method.
3. To make it a thread-safe method, `valotile` and `synchronized` should be used as shown in the example.