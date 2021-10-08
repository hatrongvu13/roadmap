package org.jax.orms;

import org.jax.orms.data.entities.Account;
import org.jax.orms.data.impl.AccountPostgres;

import java.sql.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        AccountPostgres accountPostgres = new AccountPostgres();
        Account account = new Account();

        account.setUsername("acac");
        account.setPassword("ascasc");
        account.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        account.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));

        account =  accountPostgres.insertAccount(account);
        System.out.println(account);
    }
}
