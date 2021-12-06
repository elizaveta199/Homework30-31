package hm30db;

import exception.IllegalDayException;
import exception.IllegalStepsException;

import java.sql.*;

import static java.lang.String.format;

public class ManagerOld {
    private static Connection CONNECTION;

    private int managerId;

    public ManagerOld(int managerId) {
        this.managerId = managerId;
    }

    public void add(int day, int steps) throws IllegalDayException, IllegalStepsException {
        try {
            Statement statement = CONNECTION.createStatement();

            ResultSet manager = getManagerByIDs(managerId, day);
            if (manager.isBeforeFirst()) {
                manager.first();

                int updatedSteps = manager.getInt("steps") + steps;
                String update = format("update manager\n" +
                                "set steps = %d\n" +
                                "where id = %d and day = %d;",
                        updatedSteps, managerId, day);

                statement.execute(update);
            } else {
                String insert = format("INSERT INTO manager VALUES (%d, %d, %d);", managerId, day, steps);
                statement.execute(insert);
                System.out.println("value inserted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getManagerByIDs(int managerId, int day) throws SQLException {
        Statement statement = CONNECTION.createStatement();
        String select = format("SELECT * FROM manager WHERE id = %d and day = %d", managerId, day);
        return statement.executeQuery(select);
    }

    public void printAllRows() throws SQLException {
        Statement statement = CONNECTION.createStatement();
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

}
