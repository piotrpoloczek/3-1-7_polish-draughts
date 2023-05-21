package com.coolcode;

import java.util.Scanner;

public class View {

    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int getNumberBetween(int min, int max) {
        while (true) {
            System.out.printf(
                    "Please provide the number between %s and %s: ",
                    min, max
            );

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= min && choice <= max) {
                return choice;
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }

    public int getBoardSize(int min, int max, String message) {
        System.out.println(message);
        return getNumberBetween(min, max);
    }

    public String getField(String message) {
        System.out.print(message);
        String field = scanner.next();
        scanner.nextLine();
        return field;
    }
}
