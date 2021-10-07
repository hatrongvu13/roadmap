package org.jax.orms.data.impl;

import org.jax.orms.data.AccountRepository;
import org.jax.orms.data.Connections;
import org.jax.orms.data.entities.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AccountPostgres implements AccountRepository {

    String url = "jdbc:postgresql://localhost:5432/orms";
    String username = "root";
    String password = "root";
    private Connections  connections = new ConnectionsPostgres(url, username, password);

    @Override
    public Account insertAccount(Account account) {
        String sqlInsert = "INSERT INTO account(username, password, createdDate, updatedDate)\n" +
                "VALUES ( ? , ? , ? ,? )";
        Connection connection = connections.getConnect();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            connections.close(connection);
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> insertAccount(List<Account> accounts) {
        return null;
    }

    @Override
    public Account delete(Account account) {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public Account find(int id) {
        return null;
    }

    @Override
    public Account find(String word, String column) {
        return null;
    }
}
