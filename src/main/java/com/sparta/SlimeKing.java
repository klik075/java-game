package com.sparta;

import java.util.Random;

public final class SlimeKing {
    private static final int MAX_HP = 90;

    private final Random random = new Random(56);
    private int hp = MAX_HP;
    private int nextDamage;

    public SlimeKing() {
        prepareNextAttack();
    }

    public void takeDamage(int damage) {
        if (damage <= 0) return;
        hp = Math.max(0, hp - damage);
    }

    public void prepareNextAttack() {
        nextDamage = random.nextInt(3) * 18;
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