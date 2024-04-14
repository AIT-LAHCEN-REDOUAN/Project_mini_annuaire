package DB;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JDBC {
    static DataSource dataSource;

    static {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/miniannuaire");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static void connect() {
        // No need to manually establish connection, as DataSource manages it

    }

    public static ResultSet select(String query) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeQuery(query);
        }
    }

    public static Integer execut(String query) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        }
    }

    public static void disconnect() {
        // No need to manually close connection, as DataSource manages it
    }
}
