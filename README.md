# java-design-patterns
Java implementation of the most common design patterns

# Singleton Pattern Documentation

## Overview
The `Singleton` class is an implementation of the Singleton design pattern in Java. This pattern ensures that only one instance of the class is created and provides a global point of access to that instance.

## Class: `Singleton`

### Package
```java
package creational;
```
The class is part of the `creational` package, following the categorization of design patterns into creational, structural, and behavioral patterns.

### Description
The `Singleton` class ensures that only one instance of itself is created and provides a global point of access to it. This is achieved by:
- Keeping a private static reference to the single instance.
- Providing a static method (`getInstance`) to return the instance.
- Using a private constructor to prevent external instantiation.

### Fields

#### `private static Singleton instance`
- Stores the single instance of `Singleton`.
- Initialized only when `getInstance` is called for the first time.

#### `public String value`
- Holds a string value assigned during instance creation.
- Demonstrates that the singleton instance can store data.

### Constructor

#### `private Singleton(String value)`
- Private to restrict direct instantiation.
- Initializes the `value` field.

### Methods

#### `static Singleton getInstance(String value)`
```java
static Singleton getInstance(String value)
```
- Returns the singleton instance.
- If an instance does not exist, it creates one with the provided `value`.
- If an instance already exists, it ignores the `value` parameter and returns the existing instance.

### Usage Example
```java
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton firstInstance = Singleton.getInstance("First Instance");
        System.out.println(firstInstance.value);

        Singleton secondInstance = Singleton.getInstance("Second Instance");
        System.out.println(secondInstance.value);
    }
}
```
#### Expected Output
```
First Instance
First Instance
```
- The second call to `getInstance` does not create a new instance; it returns the existing one.
- The `value` remains unchanged from the first initialization.

## Considerations & Improvements

### 1. **Thread Safety Issue**
- The current implementation is not thread-safe. Multiple threads could create multiple instances simultaneously.
- A **synchronized** method or **double-checked locking** can be used for thread safety.

### 2. **Lazy Initialization**
- The instance is created only when `getInstance` is called for the first time. This is efficient in terms of memory but needs synchronization for multithreading.

### 3. **Alternative Implementations**
#### Thread-Safe Singleton Using Synchronized Method
```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```
#### Singleton Using Double-Checked Locking
```java
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
#### Singleton Using Enum (Best Practice)
```java
public enum Singleton {
    INSTANCE;
    public void someMethod() {
        System.out.println("Singleton using Enum");
    }
}
```
- The **Enum Singleton** approach provides built-in thread safety and protects against serialization attacks.

## Conclusion
The `Singleton` pattern is a useful design pattern for scenarios where only one instance of a class is required. However, care must be taken to handle thread safety and other concerns. The `Enum` approach is often recommended as the best practice for implementing Singletons in Java.

