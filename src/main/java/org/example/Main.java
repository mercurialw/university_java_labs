package org.example;

public class Main {
    public static void main(String[] args) {
        MyContainer<String> myContainer = new MyContainer<>(5);
        myContainer.add("A");
        System.out.println("Size: " + myContainer.getSize() + " , capacity: " + myContainer.getCapacity());
        myContainer.add("B");
        System.out.println("Size: " + myContainer.getSize() + " , capacity: " + myContainer.getCapacity());
        myContainer.add("C");
        System.out.println("Size: " + myContainer.getSize() + " , capacity: " + myContainer.getCapacity());
        myContainer.add("D");
        System.out.println("Size: " + myContainer.getSize() + " , capacity: " + myContainer.getCapacity());

        System.out.println("Contains \"A\": " + myContainer.contains("A"));
        System.out.println("Contains \"Z\": " + myContainer.contains("Z"));

        myContainer.remove("A");
        System.out.println("Contains \"A\": " + myContainer.contains("A"));
        System.out.println("Size: " + myContainer.getSize() + " , capacity: " + myContainer.getCapacity());
    }
}