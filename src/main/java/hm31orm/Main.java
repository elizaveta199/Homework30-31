package hm31orm;

import hm31orm.model.Manager;
import hm31orm.model.ManagerId;
import hm31orm.service.ManagerService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ManagerService managerService = new ManagerService(sessionFactory);

        managerService.add(new Manager(new ManagerId(1, 1), 200));
        managerService.add(new Manager(new ManagerId(1, 2), 200));
        managerService.add(new Manager(new ManagerId(1, 2), 200));
        managerService.add(new Manager(new ManagerId(1, 3), 400));
        managerService.add(new Manager(new ManagerId(1, 7), 800));
        managerService.add(new Manager(new ManagerId(1, 7), 100));

        managerService.getManagerList().forEach(System.out::println);

        managerService.add(new Manager(new ManagerId(2, 1), 200));
        managerService.add(new Manager(new ManagerId(2, 2), 200));
        managerService.add(new Manager(new ManagerId(2, 2), 200));
        managerService.add(new Manager(new ManagerId(2, 3), 400));
        managerService.add(new Manager(new ManagerId(2, 7), 800));
        managerService.add(new Manager(new ManagerId(2, 7), 100));

        managerService.getManagerList().forEach(System.out::println);

        System.out.println("Get by id: " + managerService.getManagerById(1, 1));
    }
}
