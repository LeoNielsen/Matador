package com.company;

import java.util.Scanner;

public class UI {

    private final int maxPlayers = 6;
    private final int startBalance = 30000;

    public void createAccounts() {
        String input;

        System.out.println("Skriv navnene på spillets deltagere");
        System.out.println("test Q for at quitte");


        while (Main.players.size() < maxPlayers) { //if user input Q or max players are reached
            input = getUserInput("Skriv navnet på spiller" + (Main.players.size() + 1) + ": ");
            if (!input.equalsIgnoreCase("Q")) {
                Player player = new Player(input, startBalance);
                Main.players.add(player);
            } else {
                break;
            }
        }
        System.out.println("tak, spillets deltagere er registeret!");
    }

    public static String getUserInput(String message) {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

}
