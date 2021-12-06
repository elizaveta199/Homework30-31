package hm30db;

import hm30db.model.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class DbWorker {
    private Connection connection;
    private final String dbUrl = "jdbc:h2:~/test";
    private final String user = "sa";
    private final String pass = "";

    public void init() throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, pass);
        prepareTables();
    }

    public List<Manager> getManagers() throws SQLException {
        List<Manager> managerList = new ArrayList<>();

        Statement statement = connection.createStatement();
        String select = format("SELECT * FROM manager;");

        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            Manager manager = new Manager(
                    resultSet.getInt("id"),
                    resultSet.getInt("day"),
                    resultSet.getInt("steps")
            );
            managerList.add(manager);
        }

        return managerList;
    }

    public boolean saveManager(Manager target) throws SQLException {
        ResultSet manager = getManagerByIDs(target.getId(), target.getDay());
        final PreparedStatement preparedStatement;

        if (manager.isBeforeFirst()) {
            manager.first();

            int updatedSteps = manager.getInt("steps") + target.getSteps();

            preparedStatement = connection.prepareStatement("UPDATE manager SET steps = ? WHERE id = ? AND day = ?");

            preparedStatement.setInt(1, updatedSteps);
            preparedStatement.setInt(2, target.getId());
            preparedStatement.setInt(3, target.getDay());
        } else {
            preparedStatement = connection.prepareStatement("INSERT INTO manager(id, day, steps) VALUES(?, ?, ?);");

            preparedStatement.setInt(1, target.getId());
            preparedStatement.setInt(2, target.getDay());
            preparedStatement.setInt(3, target.getSteps());
        }

        return preparedStatement.execute();
    }

    private ResultSet getManagerByIDs(int managerId, int day) throws SQLException {
        Statement statement = connection.createStatement();
        String select = format("SELECT * FROM manager WHERE id = %d and day = %d", managerId, day);
        return statement.executeQuery(select);
    }

    public void printAllRows() throws SQLException {
        Statement statement = connection.createStatement();
        String select = format("SELECT * FROM manager;");

        ResultSet resultSet = statement.executeQuery(select);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        while (resultSet.next()) {
            for (int i = 1; i <= 3; i++) {
                if (i > 1) System.out.print(",   ");
                String colValue = resultSet.getString(i);
                System.out.print(colValue + " " + resultSetMetaData.getColumnName(i));
            }
            System.out.println("");
        }

    }

    private void prepareTables() throws SQLException {
        Statement statement = connection.createStatement();

        System.out.println("Creating a table...");
        String createTableSql = "CREATE TABLE IF NOT EXISTS manager (\n" +
                "  id INTEGER NOT NULL,\n" +
                "  day INTEGER NOT NULL,\n" +
                "  steps INTEGER NOT NULL,\n" +
                "  primary key (id, day)\n" +
                ");";
        statement.execute(createTableSql);
        System.out.println("Table created!");
    }
}
