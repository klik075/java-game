package com.sparta;

public enum Action {
    ATTACK, DEFEND, HEAL;

    public static Action from(int number){
        return switch (number){
            case 1 -> ATTACK;
            case 2 -> DEFEND;
            case 3 -> HEAL;
            default -> throw new IllegalArgumentException("1, 2, 3 중 하나가 아닙니다: " + number);
        };
    }
}
