Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

---

1. Encapsulation

Encapsulation is essentially when you limit the visibility of certain properties within a class. There are certain use-cases where you would have a class and want some (if not all) properties to be private and only accessible within this class, so other classes cannot access this data directly. Instead you would use "getters" and "setters" to be able to modify the private data or obtain the data values.

---

2. Inheritance

Inheritance is used when you want to create a class based on a parent class to be able to retain similar implementations of that parent class. With inheritance, if you make a subclass, it will inherit all the functions and properties of the parent. Inheritance makes it easy to reuse code and not have to rewrite it for every new class you make. Inheritance often times goes hand-in-hand with polymorphism, which is detailed below.

---

3. Abstraction

Abstraction is used to "model" or "prototype" a class or function. An abstracted class or function will have no details about any properties or function logic, but is used to build the control flow of the program. Abstracted classes are essentially defined first and instantiated later.

---

4. Polymorphism

Polymorphism is especially useful when you have you have a base functionality that you want to either expand upon, or add additional functionality to. Polymorphism is most common when you want to make a child of some parent class, like if you have a class of Car, which has a property of 4 wheels, you can make a child class of car, called Sedan, which inherits those traits from Car, but you can then define a Sedan in more specific detail. You could then have children classes for Truck, Van, Coupe, etc, which would all be polymorphic of the parent class Car.
