package com.company;

import java.util.InputMismatchException;

public class BankAccount {

    private int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {

        return balance;
    }

    public void withdrawAmount() {
        int input = 0;
        try {
            input = Integer.parseInt(UI.getUserInput("Withdraw Amount: "));
        } catch (InputMismatchException e) {
            System.out.println("invalid");
            withdrawAmount();
        }
        balance -= input;
    }
}
