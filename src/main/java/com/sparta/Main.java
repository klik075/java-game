package com.sparta;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ActionMenu menu = new ActionMenu();
        Player player = new Player();
        List<Monster> monsters = List.of(new SlimeKing(56), new Goblin(3));

        for (Monster monster : monsters) {
            System.out.println("=== " + monster.getName() + "의 투기장 ===");
            monster.prepareNextAttack();

            for (int turn = 1; player.isAlive() && monster.isAlive(); turn++) {
                int monsterDamage = monster.getNextDamage();

                System.out.println("[" + turn + "턴] 내 HP: " + player.getHp() + " / 물약: " + player.getPotions()
                        + " | " + monster.getName() + " HP: " + monster.getHp());
                System.out.println(monster.getName() + "이 " + monsterDamage + " 피해를 준비합니다!");

                int choice = menu.choose();

                Action action = Action.from(choice);

                int damageToPlayer = monsterDamage;

                switch (action) {
                    case ATTACK -> {
                        int damage = player.attack();
                        monster.takeDamage(damage);
                        System.out.println("내 공격! " + monster.getName() + "에게 " + damage + " 피해.");
                    }
                    case DEFEND -> {
                        damageToPlayer = player.defend(monsterDamage);
                        System.out.println("방어! " + damageToPlayer + " 피해만 받았습니다.");
                    }
                    case HEAL -> {
                        if (player.hasPotion()) {
                            int healed = player.heal();
                            System.out.println("물약 사용! HP를 " + healed + " 회복했습니다.");
                        } else {
                            System.out.println("물약이 없습니다!");
                        }
                    }
                }

                if (!monster.isAlive()) {
                    break;
                }

                if (action != Action.DEFEND) {
                    player.takeDamage(damageToPlayer);
                    System.out.println(monster.getName() + "의 공격! " + damageToPlayer + " 피해.");
                }

                if (player.isAlive()) {
                    monster.prepareNextAttack();
                }
            }

            if (!player.isAlive()) {
                System.out.println("내 HP가 0이 되었습니다. 패배...");
                return;
            }

            player.gainPotion();
            System.out.println(monster.getName() + "을 쓰러뜨렸습니다! 물약을 하나 얻었습니다.");
        }

        System.out.println("모든 몬스터를 물리쳤습니다! 승리!");
    }

}