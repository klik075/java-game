package com.sparta;

import java.util.Random;

public final class SlimeKing extends Monster {
    public SlimeKing(int seed) {
        super("슬라임 왕", 90, new Random(seed));
    }

    @Override
    public int rollDamage() {
        return random.nextInt(3) * 18;
    }
}