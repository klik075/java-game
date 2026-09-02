package com.sparta;

import java.util.Random;

public class Player {
    private static final int MAX_HP = 100;
    private static final int HEAL_AMOUNT = 25;

    private final Random attackRandom = new Random(40);
    private int hp = MAX_HP;
    private int potions = 2;

    public int attack() {
        return 12 + attackRandom.nextInt(7);
    }

    public int defend(int incomingDamage) {
        int damageTaken = Math.max(0, incomingDamage) / 4;
        takeDamage(damageTaken);
        return damageTaken;
    }

    public int heal() {
        if (potions == 0) {
            return 0;
        }

        int before = hp;
        hp = Math.min(MAX_HP, hp + HEAL_AMOUNT);
        potions--;
        return hp - before;
    }

    public void takeDamage(int damage) {
        if (damage <= 0) return;
        hp = Math.max(0, hp - damage);
    }

    public int getHp() {
        return hp;
    }

    public int getPotions() {
        return potions;
    }

    public boolean hasPotion() {
        return potions > 0;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void gainPotion() {
        potions++;
    }
}