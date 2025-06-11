
# Java Classes, Objects, and Methods 

## What is a class?
A class is a blueprint for creating objects. It defines the properties and behavior of the object.
**Syntax**
```java
class classname{
    // fields (variable)
  // methods
}
```
**Example**
```java
class Car {
  String color;
  int speed;

  void drive() {
    System.out.println("Car is driving");
  }
}

```
## Members: Fields and Methods
- Fields(Variable): Represent the data/state of an object.
- Methods: Define the behavior of object.
**Example**
```java
class Person {
    String name;      // field
    int age;          // field

    void speak() {    // method
        System.out.println("Hello, my name is " + name);
    }
}

```
---

## Access Modifiers

| Modifier   | Accessible within class | Same package | Subclass | Everywhere |
|------------|--------------------------|--------------|----------|------------|
| `private`  | ✅                       | ❌           | ❌       | ❌         |
| `default`  | ✅                       | ✅           | ❌       | ❌         |
| `protected`| ✅                       | ✅           | ✅       | ❌         |
| `public`   | ✅                       | ✅           | ✅       | ✅         |
---
## Static vs Non-Static 
- Static: Belongs to the class, shared among all instance. Can be accessed without creating an object.
- Non-static: Belongs to an instance of the class.
**Example**
```java
class MathUtils {
    static int add(int a, int b) {
        return a + b;
    }
}

class Counter {
    int count = 0; // non-static, each object has its own copy
}

```
**Usage:**
```java
int result = MathUtils.add(3, 4);  // static method call

```
##  Creating Objects
- To use a class, you need to create an object(instance) of it using the new keyword.
  **Syntax**
```java
ClassName obj = new ClassName();

```
**Example**
```java
class Animal {
  void makeSound() {
    System.out.println("Some sound");
  }
}

public class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();  // object creation
    myAnimal.makeSound();            // method call
  }
}

```
### WAP to create a class Student with fields name, age, and rollNo. Create an object and display its data.
`Ans: `
```java
// Student.java
class Student {
    // Fields (members)
    String name;
    int age;
    int rollNo;

    // Method to display data
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll No: " + rollNo);
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        // Object creation
        Student s1 = new Student();

        // Assign values to fields
        s1.name = "Alice";
        s1.age = 20;
        s1.rollNo = 101;

        // Display data
        s1.display();
    }
}

```
### WAP to demonstrate static and non-static members in a class.
```java
// DemoStaticNonStatic.java
class Counter {
    static int staticCount = 0; // Static member (shared across objects)
    int instanceCount = 0;      // Non-static member (separate for each object)

    void increment() {
        staticCount++;
        instanceCount++;
    }

    void displayCounts() {
        System.out.println("Static Count: " + staticCount);
        System.out.println("Instance Count: " + instanceCount);
    }
}

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.increment();
        c1.displayCounts();

        c2.increment();
        c2.displayCounts();
    }
}

```

##  Memory allocation for object in Java
- Java uses heap and stack memory during program execution. 
### 🧠 Heap Memory
- Used to store objects and instance variables (non-static fields).
- Memory is allocated when you create an object using new.
- Objects remain in the heap until they're no longer referenced, after which they are removed by garbage collection.

### 🧾 Stack Memory
- Used for storing method calls, local variables, and references to objects.
- Stack memory is short-lived and automatically cleaned up after method execution.
**Example**
```java
class Book {
    String title;
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book(); // b1 reference is in the stack
        b1.title = "Java Programming"; // Object is in the heap
    }
}

```
- `b1` is a reference stored on the stack.
- The actual Book object is created in the heap.
## 📌 Reference Types vs Primitive Types in Java

Java has two main types of data:

- **Primitive Types**: Behave like value types. Stored directly in the stack (or inside the object if part of a class).
- **Reference Types**: Store a reference (memory address) to the actual object, which resides in the heap.

---

### 🔹 Primitive Types (Value-like behavior)

Primitive types hold the actual value, not a reference.

| Type      | Example   |
|-----------|-----------|
| `int`     | 1         |
| `double`  | 3.14      |
| `char`    | 'A'       |
| `boolean` | true      |

**Example:**
```java
int a = 10;
int b = a;
b = 20;
System.out.println(a); // 10 – primitive copy

```
### Reference Type:
- Stores reference(addresses) to object in the heap
| Examples |
| -------- |
| Objects  |
| Arrays   |
| Strings  |
```java
class Person {
    String name;
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "Alice";

        Person p2 = p1; // Both p1 and p2 refer to the same object
        p2.name = "Bob";

        System.out.println(p1.name); // Bob – because it's the same object
    }
}

```
---

## Constructor
- A constructor is a special method used to initialize objects in Java. It is called automatically when an object is created using the new keyword.
- It has the same name as the class.
- It does not have a return type (not even void).
- Used to set initial values for object attributes.


## 🔹 Types of Constructors

### 1. **Default Constructor**
- A constructor that has **no parameters**
- Automatically provided by Java if no other constructor is defined
- Used for creating objects with default values
```java
class Car {
    Car() {
        System.out.println("Default constructor called");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();  // Default constructor is called
    }
}

```
### 2. **Parameterized Constructor**
- A constructor that takes one or more **arguments**
- Allows setting custom values during object creation
```java
class Car {
    String model;
    int year;

    Car(String m, int y) {
        model = m;
        year = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 2020);
        System.out.println(car.model + " " + car.year);
    }
}

```
---

## 🔹 Constructor Overloading

Constructor overloading means defining **multiple constructors** within the same class, each with a different parameter list.
```java
class Car {
    String model;
    int year;

    Car() {
        model = "Unknown";
        year = 0;
    }

    Car(String m) {
        model = m;
        year = 2021;
    }

    Car(String m, int y) {
        model = m;
        year = y;
    }
}

```
- Each constructor is called based on the nuber and types of arguments passed when creating the object.
### Key Points:
- Helps in initializing objects in different ways
- Differentiated by number or type of parameters
- Enhances flexibility and code readability

---

## 🔹 Difference Between Constructor and Method

| Feature             | Constructor                          | Method                              |
|---------------------|--------------------------------------|--------------------------------------|
| Purpose             | Initializes objects                  | Defines object behavior              |
| Name                | Same as class                        | Any valid name                       |
| Return Type         | No return type                       | Must have a return type              |
| Invocation          | Called automatically during object creation | Called explicitly using object  |
| Inheritance         | Not inherited                        | Can be inherited                     |
| Overloading         | Supported                            | Supported                            |

---

```java
class BankAccount {
    String accountHolder;
    double balance;

    BankAccount(String name, double initialDeposit) {
        accountHolder = name;
        balance = initialDeposit;
    }
}
```

---



## 🔹 Definition and Purpose of Encapsulation

**Encapsulation** is one of the core principles of object-oriented programming (OOP) in Java. It refers to the practice of **wrapping data (fields) and methods (functions) together** into a single unit, typically a class.

### Purpose:
- To restrict direct access to some of the object's components
- To protect the integrity of the data by controlling how it's accessed or modified
- To improve maintainability and flexibility of the code

---

## 🔹 Making Fields Private

In encapsulation, class fields (variables) are declared as `private` to prevent direct access from outside the class. This ensures that the internal representation of an object is hidden from the outside world.

---

## 🔹 Providing Public Getter and Setter Methods

To allow controlled access to private fields:
- **Getter methods** are provided to **retrieve** the values.
- **Setter methods** are provided to **modify** the values.

This enables validation, logging, or other logic to be included during access or update of the fields.

---

## 🔹 Benefits of Encapsulation

### ✅ Data Hiding
- Prevents external classes from accessing internal object details directly
- Reduces the risk of unintended interference or misuse

### ✅ Controlled Access
- Allows validation before setting a value (e.g., not allowing negative age)
- Makes future changes to internal implementation easier without affecting external code

### ✅ Increased Maintainability
- Centralized control of how fields are accessed or modified
- Easier to debug and modify code due to better organization

### ✅ Improved Modularity
- Each class manages its own data, leading to better organized and modular code

**Example: Encapsulation with getters and setters:**
```java
// File: Person.java
public class Person {
    // Private fields
    private String name;
    private int age;

    // Public getter for name
    public String getName() {
        return name;
    }

    // Public setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Public getter for age
    public int getAge() {
        return age;
    }

    // Public setter for age with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be positive.");
        }
    }
}

```


## 🔹  Abstraction?

**Abstraction** is one of the core principles of Object-Oriented Programming (OOP). It refers to the concept of **hiding the internal implementation details** and showing only the **essential features** of an object.

### Purpose:
- To reduce complexity by focusing only on relevant details
- To enable more flexible and reusable code
- To define a **contract** or **template** for subclasses to follow

---

## 🔹 Abstract Classes and Methods

### Abstract Class:
- A class that **cannot be instantiated** directly.
- May contain **abstract methods** (without body) and **concrete methods** (with implementation).
- Used as a **base class** to be extended by subclasses.

### Abstract Method:
- Declared using the `abstract` keyword.
- Contains no body; implementation is provided by the subclass.

---

## 🔹 Interface vs Abstract Class

| Feature                     | Abstract Class                         | Interface                              |
|-----------------------------|----------------------------------------|-----------------------------------------|
| Inheritance                 | Supports single inheritance only       | Supports multiple inheritance (via multiple interfaces) |
| Methods                     | Can have abstract and non-abstract methods | All methods are abstract by default (until Java 8) |
| Fields                      | Can have instance variables            | Only static and final variables allowed |
| Constructor                 | Can have constructors                  | Cannot have constructors                |
| Access Modifiers            | Can use any access modifier            | All methods are implicitly `public`     |
| Purpose                     | For base classes with shared code      | For defining a contract across unrelated classes |



## 🔹 Real-Life Examples of Abstraction

### 🚗 Vehicle Example
- **Abstract Class**: `Vehicle` (abstract) with methods like `start()` and `stop()`.
- **Subclasses**: `Car`, `Bike`, `Truck` provide specific implementations.
  **Examples**
```java
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started with key");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike started with button");
    }
}

```
### 📷 Device Example
- **Interface**: `Camera` with `takePhoto()` and `recordVideo()`.
- **Implemented by**: `Smartphone`, `Webcam`, `DSLR`.
```java
interface Camera {
    void takePhoto();
    void recordVideo();
}

class Smartphone implements Camera {
    public void takePhoto() {
        System.out.println("Smartphone takes photo");
    }
    public void recordVideo() {
        System.out.println("Smartphone records video");
    }
}

class Webcam implements Camera {
    public void takePhoto() {
        System.out.println("Webcam takes photo");
    }
    public void recordVideo() {
        System.out.println("Webcam records video");
    }
}

```
---

## 🔹Polymorphism?

**Polymorphism** means "many forms". In Java, it allows objects to be treated as instances of their parent class rather than their actual class. It enables a single interface to represent different underlying forms (data types).

## 🔹 Types of Polymorphism

### 1. Compile-time Polymorphism (Method Overloading)

- Achieved by defining multiple methods with the **same name** but different parameter lists.
- Resolved during **compile time**.
- Also known as **static polymorphism**.
- Commonly used to increase code readability and flexibility.

**Example**
```java

```
### 2. Run-time Polymorphism (Method Overriding)

- Occurs when a subclass provides a specific implementation of a method already defined in the superclass.
- Resolved during **runtime**.
- Also called **dynamic polymorphism**.
- Enables behavior to be determined at runtime depending on the object type.
**Example**
```java

```

---

## 🔹 Upcasting and Dynamic Method Dispatch

### Upcasting:
- Refers to treating a subclass object as an instance of its superclass.
- Useful when handling a group of objects with a common base type.

### Dynamic Method Dispatch:
- Java resolves the method call at runtime based on the **actual object type**, not the reference type.
- Enables true polymorphic behavior.

**Example**
```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s;

        s = new Circle();     // Upcasting
        s.draw();             // Dynamic dispatch → "Drawing a circle"

        s = new Rectangle();  // Upcasting
        s.draw();             // Dynamic dispatch → "Drawing a rectangle"
    }
}

```
## Use in  Real-World Problems
- Extensibility: Allows writing more general and reusable code.
- Scalability: New classes can be added with little or no changes to existing code.
- Example Scenarios:
  - A Payment system where CreditCard, UPI, and Cash all implement the same pay() method.

  - A game where different Enemy types (Zombie, Alien, Monster) inherit from a common Enemy superclass.

  - A drawing app where Circle, Rectangle, and Line extend a common Shape class and override the draw() method.

**Example**
```java
abstract class Payment {
  abstract void pay(double amount);
}

class CreditCard extends Payment {
  void pay(double amount) {
    System.out.println("Paid $" + amount + " using Credit Card.");
  }
}

class UPI extends Payment {
  void pay(double amount) {
    System.out.println("Paid $" + amount + " using UPI.");
  }
}

class Cash extends Payment {
  void pay(double amount) {
    System.out.println("Paid $" + amount + " in Cash.");
  }
}

public class PaymentProcessor {
  public static void main(String[] args) {
    Payment p;

    p = new CreditCard();
    p.pay(500);

    p = new UPI();
    p.pay(200);

    p = new Cash();
    p.pay(100);
  }
}
```
---

## Super Class
- A superclass is a class that is extended or inherited by another class.
- It contains common attributes (fields) and methods (functions) that can be shared by multiple subclasses.
- Also called a parent class or base class.
- Example: If Animal is a class, and Dog and Cat inherit from it, then Animal is the superclass.
## Sub Class
- A subclass is a class that inherits from a superclass.
- It can use the fields and methods of the superclass.
- It can also add its own specific fields and methods or override superclass methods to provide specialized behavior.
- Also called a child class or derived class.

Example: Dog is a subclass of Animal and can inherit the behaviors of Animal while adding dog-specific behaviors.

---
## 🔄 Inheritance
- Inheritance is a fundamental OOP concept where a new class (subclass) derives properties and behaviors from an existing class (superclass).

- It creates an “is-a” relationship. For example, a Dog is an Animal.
```java
class Employee {
    String name;
    void display() {
        System.out.println("Name: " + name);
    }
}

class Officer extends Employee {
    String grade;
}
```

---
# `extends` and `super` Keywords in Java

## `extends` Keyword
- Used to **inherit** a class in Java.
- Signifies that one class is a **subclass** (child) of another class (**superclass** or parent).
- The subclass inherits all accessible fields and methods from the superclass.
- **Syntax:**
  ```java
  class Superclass {
      // fields and methods
  }

  class Subclass extends Superclass {
      // additional fields and methods or overrides
  }
## `super` Keyword

The `super` keyword has two main uses in inheritance:

### 1. Accessing Superclass Members

- Used inside a subclass to refer to the **immediate superclass**'s methods or variables.
- Useful when the subclass overrides a method but still wants to call the superclass version.

**Example:**

```java
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("Dog is eating");
    }

    void callSuperEat() {
        super.eat();  // Calls Animal's eat method
    }
}
```
---

# `final` Class and Method in Java

## `final` Class

- A class declared with the `final` keyword **cannot be subclassed** (i.e., no other class can extend it).
- This is used to **prevent inheritance** and to **secure** the class from being modified by subclassing.
- Useful for creating immutable classes or for security reasons.

**Example:**

```java
final class Vehicle {
    void display() {
        System.out.println("This is a vehicle.");
    }
}

// The following would cause a compile-time error:
// class Car extends Vehicle { }
```
## `final` Method 

- A method declared as `final` **cannot be overridden** by any subclass.
- Ensures that the specific implementation of the method remains unchanged in inheritance hierarchies.
- Allows a class to be extended but prevents modification of certain methods.

**Example:**

```java
class Vehicle {
    final void start() {
        System.out.println("Vehicle is starting.");
    }
}

class Car extends Vehicle {
    // The following would cause a compile-time error:
    // void start() {
    //     System.out.println("Car is starting.");
    // }
}
```
---

# 🧩 What is an Interface?

An **interface** in Java is a collection of **abstract methods** (methods without a body) and **constants**.  
Interfaces are used to define a **contract** that implementing classes must follow.

### ✅ Key Points:
- Interfaces can only have method **declarations**, not implementations (except default/static methods).
- A class uses the `implements` keyword to implement an interface.
- A class **must implement all methods** of the interface unless it's declared `abstract`.

### Interface Declaration
```java
interface InterfaceName {
    void method1();
    void method2();
}
```
**Class implementaion**
```java
class ClassName implements InterfaceName {
    public void method1() {
        // implementation
    }

    public void method2() {
        // implementation
    }
}
```
**Example**

```java
interface Animal {
    void sound();
    void eat();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }

    public void eat() {
        System.out.println("Dog eats bones");
    }
}

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();  // Output: Dog barks
        d.eat();    // Output: Dog eats bones
    }
}

```
### Interface vs Abstract Class
-.
| Feature               | Interface                        | Abstract Class                    |
|-----------------------|----------------------------------|-----------------------------------|
| Methods               | Only abstract (until Java 8)     | Can have both abstract & concrete |
| Constructors          | Not allowed                      | Allowed                           |
| Variables             | `public static final` only       | Any type                          |
| Multiple Inheritance  | Yes (via multiple interfaces)    | No                                |
