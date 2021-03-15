package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Player> players = new ArrayList<>();
    public static UI ui = new UI();



    public static void main(String[] args) {

        try {
            readAccountData();
            //todo: show option (continue last game, or create new game)
        } catch (IOException e) {
            System.out.println("ingen data gemt");
            ui.createAccounts();
        }

//        System.out.println(findPlayerByID(1));

//        System.out.println(getPlayersData());

//        players.get(0).getAccount().withdrawAmount();

//        System.out.println(getPlayersData());
//        saveGameData();
    }

    private static void readAccountData() throws IOException {
        File file = new File("data.txt");
        Scanner scan = new Scanner(file);
        String[] accountLine;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println(line);
            accountLine = line.split(":");
            players.add(new Player(accountLine[0], Integer.parseInt(accountLine[1])));
        }
    }

    public static void saveGameData() {
        String gameData = "";
        for (Player p : players) {
            gameData += p.getPlayerName() + ":" + p.getAccount() + "\n";
        }

        gameData = getPlayersData();

        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.write(gameData);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getCause());
        }
    }

    public static String getPlayersData() {
        String s = "";

        for (Player p : players) {
            s += p.toString() + "\n";
        }
        return s;
    }

    public static Player findPlayerByID (int id){
        return players.get(id);
    }

}
