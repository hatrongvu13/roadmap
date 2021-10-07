package org.jax.orms.data.impl;

import lombok.*;
import org.jax.orms.data.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class ConnectionsPostgres implements Connections {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static Connection connection;

    private String host;
    private String username;
    private String password;

    public ConnectionsPostgres(String host, String username, String password) {
        if (connection == null) {
            this.host = host;
            this.username = username;
            this.password = password;
//            this.getConnect();
        }
    }

    @Override
    public Connection getConnect() {
        if (connection != null) {
            System.out.println("Connection is already connect.");
            return connection;
        }
        try {
            connection = DriverManager.getConnection(host, username, password);
            System.out.println("Connection ... ");
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
            System.out.println("Close connection successfully !");
            connection = null;
        } catch (SQLException throwables) {
            System.err.println("Error when close connection .... !");
            throwables.printStackTrace();
        }
    }
}
