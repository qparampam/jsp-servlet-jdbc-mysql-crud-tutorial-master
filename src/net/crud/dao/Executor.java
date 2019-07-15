package crud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    private final Connection connection;

    Executor(Connection connection) {
        this.connection = connection;
    }

    void execUpdate(String update) throws SQLException {
        try {
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            stmt.execute(update);
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

    }

    <T> T execQuery(String query, ResultHandler<T> handler)
            throws SQLException {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            ResultSet result = stmt.getResultSet();
            T value = handler.handle(result);
            result.close();
            stmt.close();
            return value;
        } catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
