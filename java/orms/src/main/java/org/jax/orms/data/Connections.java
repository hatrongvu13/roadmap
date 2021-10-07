package org.jax.orms.data;

import java.sql.Connection;
public interface Connections {

    Connection getConnect();

    void close(Connection connection);
}
