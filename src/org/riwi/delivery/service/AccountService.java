package org.riwi.delivery.service;

import org.riwi.delivery.model.Rol;
import org.riwi.delivery.model.entity.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountService {
    private final ArrayList<Account> accounts = new ArrayList<>();
    private boolean state;
    Scanner objScanner = new Scanner(System.in);

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account registerAccount() {
        System.out.print("Enter your email:");
        String email = objScanner.next();
        System.out.print("Enter your password:");
        String password = objScanner.next();
        System.out.print("Enter your rol:");
        String rol = objScanner.next();
        String id = String.valueOf(System.currentTimeMillis());

        Account account = getAccountByEmail(email);

        if (account == null) {
            if (rol.equalsIgnoreCase("client")) {
                Rol rolEmun = Rol.CLIENT;
                account = new Account(id, email, password, rolEmun);
            } else if (rol.equalsIgnoreCase("deliveryman")) {
                Rol rolEmun = Rol.DELIVERYMAN;
                account = new Account(id, email, password, rolEmun);
            }
            accounts.add(account);

        } else System.out.println("This email address has already");
        return account;
    }

    public boolean loginAccount(String email, String password) {
        Account account = getAccountByEmail(email);
        if (account != null && account.getPassword().equalsIgnoreCase(password)) {
            state = true;
            return true;
        }
        return false;
    }

    public Account getAccountByEmail(String email) {
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                if (account.getEmail().equals(email)) {
                    return account;
                }
            }
        }
        return null;
    }

    public void logOut() {
        state = false;
    }

    public void showAccounts() {
        for (Account account : accounts) {
            System.out.println("Name:" + account.getEmail());
            System.out.println("Id:" + account.getId());
            System.out.println("Rol:" + account.getRol());
            System.out.println();
        }
    }
}
