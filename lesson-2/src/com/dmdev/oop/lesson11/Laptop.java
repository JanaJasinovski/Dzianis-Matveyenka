package com.dmdev.oop.lesson11;

public final class Laptop extends Computer {
    private int weight;

    {
        System.out.println("init block laptop");
    }

    static {
        System.out.println("static block laptop");
    }

    public Laptop() {
        System.out.println("Constructor laptop");
    }

    @Override
    public void load() {
        open();
        System.out.println("Я загрузился");
    }

    public Laptop(Ssd ssd, Ram ram, int weight) {
        super(ssd, ram);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void open() {
        System.out.println("Открыл крышку");
    }
}
