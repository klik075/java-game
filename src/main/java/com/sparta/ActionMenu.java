package com.sparta;

import java.util.Scanner;

public class ActionMenu {
    private final Scanner scanner = new Scanner(System.in);

    public int choose() {
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