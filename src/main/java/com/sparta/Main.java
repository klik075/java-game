package com.sparta;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxHp = 100;
        int playerHp = maxHp;
        int potions = 2;
        int bossHp = 90;

        Random bossRandom = new Random(56);
        Random attackRandom = new Random(40);

        System.out.println("=== 슬라임 왕의 투기장 ===");

        for (int turn = 1; playerHp > 0 && bossHp > 0; turn++) {
            int bossDamage = bossRandom.nextInt(3) * 18;

            System.out.println("[" + turn + "턴] 내 HP: " + playerHp + " / 물약: " + potions
                    + " | 슬라임 왕 HP: " + bossHp);
            System.out.println("슬라임 왕이 " + bossDamage + " 피해를 준비합니다!");

            int choice = readChoice(scanner);

            int damageToPlayer = bossDamage;

            if (choice == 1) {
                int attackDamage = 12 + attackRandom.nextInt(7);
                bossHp = Math.max(0, bossHp - attackDamage);
                System.out.println("내 공격! 슬라임 왕에게 " + attackDamage + " 피해.");
            } else if (choice == 2) {
                damageToPlayer = bossDamage / 4;
                playerHp = Math.max(0, playerHp - damageToPlayer);
                System.out.println("방어! " + damageToPlayer + " 피해만 받았습니다.");
            } else if (potions > 0) {
                int oldHp = playerHp;
                playerHp = Math.min(maxHp, playerHp + 25);
                potions--;
                System.out.println("물약 사용! HP를 " + (playerHp - oldHp) + " 회복했습니다.");
            } else {
                System.out.println("물약이 없습니다!");
            }

            if (bossHp <= 0) {
                break;
            }

            if (choice != 2) {
                playerHp = Math.max(0, playerHp - damageToPlayer);
                System.out.println("슬라임 왕의 공격! " + damageToPlayer + " 피해.");
            }
        }

        if (bossHp <= 0) {
            System.out.println("슬라임 왕을 쓰러뜨렸습니다! 승리!");
        } else if (playerHp <= 0) {
            System.out.println("내 HP가 0이 되었습니다. 패배...");
        }
    }

    private static int readChoice(Scanner scanner) {
        while (true) {
            System.out.println("1. 공격  2. 방어  3. 회복");
            System.out.print("선택 > ");
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                return Integer.parseInt(input);
            }
            System.out.println("1, 2, 3 중 하나를 입력하세요. 턴은 진행되지 않습니다.");
        }
    }
}