package db;
import model.Car;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarService {
    //@PersistenceContext(unitName = "SamplePersistenceUnit")
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SamplePersistenceUnit");

    public void insertCar(Car car) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(car);
        tx.commit();
        em.close();
    }

    public List<Car> getAllCars() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Car> cars = em.createNamedQuery("GetAllCars").getResultList();
        tx.commit();
        em.close();
        return cars;
    }
}
