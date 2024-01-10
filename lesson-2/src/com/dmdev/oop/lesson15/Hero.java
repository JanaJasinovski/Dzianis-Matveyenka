package com.dmdev.oop.lesson15;

import com.dmdev.oop.lesson18.weapon.Weapon;

public class Hero<T extends Weapon> {
    private String name;
    private int damage;
    private T weapon;

    public Hero(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public T getWeapon() {
        return weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }

    public void attackEnemy(Enemy enemy) {
        System.out.println(name + " атакует врага " + enemy.getName());
    }


}
