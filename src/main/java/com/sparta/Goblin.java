package com.sparta;

import java.util.Random;

public final class Goblin extends Monster{
    public Goblin(int seed) {
        super("고블린", 50, new Random(seed));
    }

    @Override
    public int rollDamage() {
        return 8 + random.nextInt(5);
    }
}