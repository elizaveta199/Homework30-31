package hm30db;

import hm30db.model.Manager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbWorker dbWorker = new DbWorker();
        dbWorker.init();

        dbWorker.printAllRows();

        dbWorker.saveManager(new Manager(1, 1, 200));
        dbWorker.saveManager(new Manager(1, 2, 200));
        dbWorker.saveManager(new Manager(1, 2, 200));
        dbWorker.saveManager(new Manager(1, 3, 400));
        dbWorker.saveManager(new Manager(1, 7, 800));
        dbWorker.saveManager(new Manager(1, 7, 100));

        System.out.println("AFTER ADD:\n");

        dbWorker.printAllRows();

        System.out.println();
        dbWorker.getManagers().forEach(System.out::println);

        dbWorker.saveManager(new Manager(2, 1, 200));
        dbWorker.saveManager(new Manager(2, 2, 200));
        dbWorker.saveManager(new Manager(2, 2, 200));
        dbWorker.saveManager(new Manager(2, 3, 400));
        dbWorker.saveManager(new Manager(3, 7, 800));
        dbWorker.saveManager(new Manager(4, 7, 100));

        System.out.println("AFTER ADD:\n");

        dbWorker.printAllRows();

        System.out.println();
        dbWorker.getManagers().forEach(System.out::println);
    }
}
