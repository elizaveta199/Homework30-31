package hm31orm.service;

import hm31orm.model.Manager;
import hm31orm.model.ManagerId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ManagerService {
    private final SessionFactory sessionFactory;

    public ManagerService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Добавляет нового менеджера еслм его нет, иначе прибавляет шаги
     * @param manager new Manager
     */
    public void add(Manager manager) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Manager managerFromDb = session.get(Manager.class, manager.getManagerId());
        if (managerFromDb == null) {
            session.save(manager);
        } else {
            managerFromDb.setSteps(managerFromDb.getSteps() + manager.getSteps());
            session.save(managerFromDb);
        }
        session.getTransaction().commit();
        session.close();
    }

    /**
     * get all managers
     * @return list of managers
     */
    public List<Manager> getManagerList() {
        Session session = sessionFactory.openSession();
        List<Manager> managerList = session.createQuery("SELECT m FROM Manager m", Manager.class).getResultList();
        session.close();
        return managerList;
    }

    public Manager getManagerById(Integer id, Integer day) {
        Session session = sessionFactory.openSession();
        return session.get(Manager.class, new ManagerId(id, day));
    }
}
