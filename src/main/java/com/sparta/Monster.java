package com.sparta;

import java.util.Random;

public abstract class Monster {

    protected final Random random;
    private final String name;
    private int hp;
    private int nextDamage;

    public Monster(String name, int maxHp, Random seed) {
        this.name = name;
        this.hp = maxHp;
        this.random = seed;
    }

    public abstract int rollDamage();

    public void prepareNextAttack() {
        nextDamage = rollDamage();
    }

    public void takeDamage(int damage) {
        if (damage <= 0) return;
        hp = Math.max(0, hp - damage);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getNextDamage() {
        return nextDamage;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
