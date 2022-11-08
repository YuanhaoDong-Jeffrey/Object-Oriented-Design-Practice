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