package com.dasun.oop;


interface Animal{

    void sound();
}

class Dog implements Animal{

    @Override
    public void sound() {
        System.out.println("bauuuu");
    }
}

class Cat implements Animal{

    @Override
    public void sound() {
        System.out.println("meyauuu");
    }
}


public class Polymorphism {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();
        animal = new Cat();
        animal.sound();
    }
}
