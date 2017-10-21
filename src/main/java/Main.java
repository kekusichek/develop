import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        user.setName("wdtfoxs");
        user.setPassword("kek123");
        EntityManager persistenceManager = PersistenceManager.INSTANCE.getEntityManager();
        persistenceManager.getTransaction().begin();
        persistenceManager.persist(user);
        user.setName("3211123");
        persistenceManager.getTransaction().commit();
        persistenceManager.close();
        persistenceManager = PersistenceManager.INSTANCE.getEntityManager();
        persistenceManager.getTransaction().begin();
//        persistenceManager.close();

//        persistenceManager.refresh(user);
//        User newUser = persistenceManager.merge(user);
//        newUser.setName("test detach to persist №3");

//        persistenceManager.getTransaction().commit();
//        persistenceManager.close();
//        persistenceManager = PersistenceManager.INSTANCE.getEntityManager();
//        persistenceManager.getTransaction().begin();
        user.setName("kek");
        persistenceManager.merge(user);
//        Query query = persistenceManager.createNamedQuery("User.getByName321");
//        List resultList = query.getResultList();
//        for (Object u: resultList) {
//            System.out.println(((User) u).getName());
//        }
        persistenceManager.getTransaction().commit();
        persistenceManager.close();
        PersistenceManager.INSTANCE.close();
    }
}
