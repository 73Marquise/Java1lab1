package org.example;

public class Main {
    public static void main(String[] args) {
        Container<Integer> container = new Container<>();
        container.add(10);
        container.add(20);
        container.add(55);
        container.remove(2);
        container.add(25);
        System.out.println(container.get(0));
        System.out.println(container.get(1));
        System.out.println(container.get(2));
    }
}