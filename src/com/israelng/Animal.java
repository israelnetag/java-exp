package com.israelng;

import java.io.Serializable;

public  class Animal implements Serializable ,Cloneable{
    private String name;
    private int age;
    private String type;

    public Animal(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return "name: " + name + " age: " + age + " type: " + type;
    }
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Animal)) return false;
        Animal animal = (Animal) obj;
        return animal.name.equals(this.name) && animal.age == this.age && animal.type.equals(this.type);
    }
    public int hashCode() {
        return name.hashCode() + Double.hashCode(age) + type.hashCode();
    }
    static final long serialVersionUID = 1L;
}
 class Dog extends Animal {
    private String breed;
    public Dog(String name, int age, String type, String breed) {
        super(name, age, type);
        this.breed = breed;
    }
    public String toString() {
        return super.toString() + " breed: " + breed;
    }
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Dog)) return false;
        Dog dog = (Dog) obj;
        return super.equals(dog) && dog.breed.equals(this.breed);
    }
    public int hashCode() {
        return super.hashCode() + breed.hashCode();
    }
    static final long serialVersionUID = 1L;
}
/** important things to remember for the exam in oop and java
 * 1. abstract class can have abstract and non abstract methods
 * 2. abstract class can have constructors
 * 3. abstract class can have instance variables
 * 4. abstract class can have static variables
 * 5. abstract class can have static methods
 * 6. abstract class can have final methods
 * 7. abstract class can have final variables
 * 8. abstract class can have private methods
 * 9. abstract class can have private variables
 * 10. abstract class can have private static methods
 * 11. abstract class can have private static variables
 * 12. abstract class can have private final methods
 * 13. abstract class can have private final variables
 * 14. abstract class can have protected methods
 * 15. abstract class can have protected variables
 * 16. abstract class can have protected static methods
 * 17. abstract class can have protected static variables
 * 18. abstract class can have protected final methods
 * 19. abstract class can have protected final variables
 * 20. abstract class can have protected private methods
 * 21. abstract class can have protected private variables
 *
 *
 *

// A.this.a
// a.new B()

 */