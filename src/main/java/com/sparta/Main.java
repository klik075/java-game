package com.sparta;

public class Main {
    public static void main(String[] args) {
        ActionMenu menu = new ActionMenu();
        Player player = new Player();
        SlimeKing slimeKing = new SlimeKing();

        System.out.println("=== 슬라임 왕의 투기장 ===");

        for (int turn = 1; player.isAlive() && slimeKing.isAlive(); turn++) {
            int bossDamage = slimeKing.getNextDamage();

            System.out.println("[" + turn + "턴] 내 HP: " + player.getHp() + " / 물약: " + player.getPotions()
                    + " | 슬라임 왕 HP: " + slimeKing.getHp());
            System.out.println("슬라임 왕이 " + bossDamage + " 피해를 준비합니다!");

            int choice = menu.choose();
            int damageToPlayer = bossDamage;

            if (choice == 1) {
                int damage = player.attack();
                slimeKing.takeDamage(damage);
                System.out.println("내 공격! 슬라임 왕에게 " + damage + " 피해.");
            } else if (choice == 2) {
                damageToPlayer = player.defend(bossDamage);
                System.out.println("방어! " + damageToPlayer + " 피해만 받았습니다.");
            } else if (player.hasPotion()) {
                int healed = player.heal();
                System.out.println("물약 사용! HP를 " + healed + " 회복했습니다.");
            } else {
                System.out.println("물약이 없습니다!");
            }

            if (!slimeKing.isAlive()) break;

            if (choice != 2) {
                player.takeDamage(damageToPlayer);
                System.out.println("슬라임 왕의 공격! " + damageToPlayer + " 피해.");
            }

            if (player.isAlive()) {
                slimeKing.prepareNextAttack();
            }
        }

        if (!slimeKing.isAlive()) {
            System.out.println("슬라임 왕을 쓰러뜨렸습니다! 승리!");
        } else if (!player.isAlive()) {
            System.out.println("내 HP가 0이 되었습니다. 패배...");
        }
    }
}