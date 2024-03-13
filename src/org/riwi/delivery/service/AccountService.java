package org.riwi.delivery.service;

import org.riwi.delivery.model.Rol;
import org.riwi.delivery.model.entity.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountService {
    private ArrayList<Account> accounts;
    Scanner objScanner = new Scanner(System.in);

    public AccountService(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void createAccount() {
        System.out.print("Enter your email:");
        String email = objScanner.next();
        System.out.print("Enter your password:");
        String password = objScanner.next();
        System.out.print("Enter your rol ");
        String rol = objScanner.next();
        String id = String.valueOf(System.currentTimeMillis());

        Account account = new Account();
        account = getAccount(email);

        if (account!= null){
            if (rol.equalsIgnoreCase("client")){
                Rol rolEmun = Rol.CLIENT;
                account = new Account(id, email, password,rolEmun);
            }else if (rol.equalsIgnoreCase("deliveryman")){
                Rol rolEmun = Rol.DELIVERYMAN;
                account = new Account(id, email, password,rolEmun);
            }
            accounts.add(account);
        }else System.out.println("This email address has already");


    }
    public boolean verifyAccount(String email,String password){
        Account account = getAccount(email);
        if( account.getPassword().equalsIgnoreCase(password))
            return true;
        return false;
    }
    public Account getAccount(String email){
        for (Account account : accounts){
            if (account.getEmail().equals(email)){
                return account;
            }
        }
        return null;
    }
}
