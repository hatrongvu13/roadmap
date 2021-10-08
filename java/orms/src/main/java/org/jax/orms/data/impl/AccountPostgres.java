package org.jax.orms.data.impl;

import org.jax.orms.data.AccountRepository;
import org.jax.orms.data.Connections;
import org.jax.orms.data.entities.Account;

import java.sql.*;
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
//            connection.setAutoCommit(false);
            PreparedStatement pstm = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, account.getUsername());
            pstm.setString(2, account.getPassword());
            pstm.setTimestamp(3, account.getCreatedDate());
            pstm.setTimestamp(4, account.getUpdatedDate());

            int insert = pstm.executeUpdate();
            System.out.println(insert);

            ResultSet rs = pstm.getGeneratedKeys();

            if (rs.next()) {
                account.setAccount_id(rs.getInt(1));
            }

            connections.close(connection);
            return account;
        } catch (SQLException ex) {
            connections.close(connection);
            ex.printStackTrace();
            return null;
        }
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
