package org.riwi.delivery.controller;

import org.riwi.delivery.model.entity.Account;
import org.riwi.delivery.service.AccountService;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountController {
    private final AccountService accountService = new AccountService();
    private final ClientController clientController = new ClientController();
    Scanner objScanner = new Scanner(System.in);

    public boolean login(String email, String password) {
        return accountService.loginAccount(email, password);
    }

    public Account register() {
        return accountService.registerAccount();
    }

    public void logOut() {
        accountService.logOut();
    }

    public void show() {
        accountService.showAccounts();
    }

    public ArrayList<Account> getAccounts() {
        return accountService.getAccounts();
    }
}
