package com.company;

public class Player {

    private String playerName;
    private BankAccount account;
    private int id;
    static private int counter;

    public int getId() {
        return id;
    }

    public Player(String playerName, int balance) {

        this.playerName = playerName;
        account = new BankAccount(balance);
        this.id = counter++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public BankAccount getAccount() {
        return account;
    }

    public String toString() {
        return playerName + ":" + account.getBalance();
    }
}
