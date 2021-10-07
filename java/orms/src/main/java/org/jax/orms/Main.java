package org.jax.orms;

import org.jax.orms.data.Connections;
import org.jax.orms.data.impl.ConnectionsPostgres;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
//        try {
//
//
//            Connections connections = new ConnectionsPostgres(url, username, password);
//
//            Connection connection = connections.getConnect();
//            connections.getConnect();
//
////            Connection connection = DriverManager.getConnection(url, username, password);
////            System.out.println("Connection ...");
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getObject(2));
//            }
//            connections.close(connection);
////            connection.close();
//        } catch (SQLException throwables) {
//            System.err.println("Error when connect Postgresql !");
//            throwables.printStackTrace();
//        }
    }
}
