package com.dmdev.oop.lesson11;

public abstract class Computer implements Printable {
    private Ram ram;
    private Ssd ssd;

    {
        System.out.println("init block Computer");
    }

    static {
        System.out.println("static block Computer");
    }

    public Computer() {
        System.out.println("Constructor computer");
    }

    public Computer(Ssd ssd, Ram ram) {
        this.ssd = ssd;
        this.ram = ram;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Ssd getSsd() {
        return ssd;
    }

    public void setSsd(Ssd ssd) {
        this.ssd = ssd;
    }

    public abstract void load();

    @Override
    public final void print() {
        System.out.println("Ssd: " + ssd.getValue() + ", ram: " + ram.getValue());
    }

}
