
# Java Classes, Objects, and Methods 

### 1. What is a class?
A class is a blueprint for creating objects. It defines the properties and behavior of the object.

```java
class BankAccount {
    String accountHolder;
    double balance;

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }
}
```

### 2. Creating Objects

```java
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.accountHolder = "Alice";
        account.deposit(1000);
        System.out.println("Balance: " + account.balance);
    }
}
```

### 3. Constructor

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

### 4. Access Modifiers

| Modifier   | Accessible within class | Same package | Subclass | Everywhere |
|------------|--------------------------|--------------|----------|------------|
| `private`  | ✅                       | ❌           | ❌       | ❌         |
| `default`  | ✅                       | ✅           | ❌       | ❌         |
| `protected`| ✅                       | ✅           | ✅       | ❌         |
| `public`   | ✅                       | ✅           | ✅       | ✅         |

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
# Abstract Class and Abstract Method in Java

## Abstract Class

- An **abstract class** is a class that **cannot be instantiated** directly.
- It is declared using the `abstract` keyword.
- Can contain both **abstract methods** (without body) and **concrete methods** (with body).
- Used as a base class to provide a common template for subclasses.
- Subclasses **must** provide implementations for all abstract methods unless they are also abstract.

**Example:**

```java
abstract class Animal {
    abstract void sound();  // abstract method (no body)

    void sleep() {          // concrete method
        System.out.println("Sleeping...");
    }
}
```
## Abstract Method
- A method declared with the abstract keyword and no method body. 
- Must be implemented by subclasses.
- Used to enforce that subclasses provide specific behavior.

 **Example:**

```java

class Dog extends Animal {
    
    void sound() {
        System.out.println("Barking");
    }
}
```
---
# Upcasting and Downcasting in Java

## 🔼 Upcasting (Widening / Safe Casting)

**Definition:**  
Upcasting is when a **subclass object is referred to by a superclass reference**.  
It happens **implicitly** and is always **safe** because a subclass "is a" superclass.

### Syntax:
```java
SuperClass ref = new SubClass();
```
**Example:**

```java
class Animal {
    void sound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();  // Upcasting
        a.sound();             // Allowed
        // a.bark();          // Not allowed (compiler error)
    }
}

```
## 🔽 Downcasting (Narrowing / Risky Casting)
Definition:
- Downcasting is when a superclass reference is explicitly cast to a subclass type.
This must be done manually, and is risky — if the object is not actually of the subclass type, a ClassCastException occurs.

Syntax:
```SubClass ref = (SubClass) superClassRef;```

Example:

```java
class Animal {
void sound() {
System.out.println("Some sound");
}
}

class Dog extends Animal {
void bark() {
System.out.println("Dog barks");
}
}

public class Test {
public static void main(String[] args) {
Animal a = new Dog();   // Upcasting
Dog d = (Dog) a;        // Downcasting
d.bark();               // Allowed because actual object is Dog
}
}
```
## ⚠️ Dangerous Downcasting Example:
```java
Animal a = new Animal();
Dog d = (Dog) a;  // Runtime Error: ClassCastException
d.bark();
```
---
# 🧩 What is an Interface?

An **interface** in Java is a collection of **abstract methods** (methods without a body) and **constants**.  
Interfaces are used to define a **contract** that implementing classes must follow.

### ✅ Key Points:
- Interfaces can only have method **declarations**, not implementations (except default/static methods).
- A class uses the `implements` keyword to implement an interface.
- A class **must implement all methods** of the interface unless it's declared `abstract`.

---

## 🔧 Syntax

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

| Feature               | Interface                        | Abstract Class                    |
|-----------------------|----------------------------------|-----------------------------------|
| Methods               | Only abstract (until Java 8)     | Can have both abstract & concrete |
| Constructors          | Not allowed                      | Allowed                           |
| Variables             | `public static final` only       | Any type                          |
| Multiple Inheritance  | Yes (via multiple interfaces)    | No                                |
