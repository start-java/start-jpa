package tech.simter.start.jpa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ActorDaoTest {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Before
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-jpa");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void destroy() {
        entityManager.close();

        // if set hibernate.hbm2ddl.auto=create-drop, raise drop need to invoke close method
        entityManagerFactory.close();
    }

    @Test
    public void test() {
        entityManager.getTransaction().begin();

        // save three items
        Actor actor = new Actor(ActorType.Group, "test");
        entityManager.persist(actor);
        Assert.assertNotNull(actor.getId());
        entityManager.persist(new Actor(ActorType.User, "admin"));
        entityManager.persist(new Actor(null, "unknown"));

        // check
        List<Actor> users = entityManager.createQuery("select a from Actor a", Actor.class).getResultList();
        entityManager.getTransaction().commit();
        Assert.assertEquals(4, users.size()); // remark: inserted one item by the initial sql
    }
}