package tech.simter.start.jpa;

import com.owlike.genson.Genson;
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

  //@Test
  public void log() {
    System.out.println("---- begin ----");
    entityManager.getTransaction().begin();

    System.out.println("---- start insert ----");
    // 增
    Actor actor = new Actor(ActorType.User, "test");
    entityManager.persist(actor);
    System.out.println("actor=" + new Genson().serialize(actor));
    System.out.println("---- end insert ------");

    // 查
    System.out.println("---- start find ----");
    List<Actor> users = entityManager.createQuery("select a from Actor a where type=?", Actor.class)
      .setParameter(1, ActorType.User)
      .getResultList();
    Assert.assertFalse(users.isEmpty());
    System.out.println("actors=" + new Genson().serialize(users));
    System.out.println("---- end find ------");

    entityManager.getTransaction().commit();
    System.out.println("---- end ------");
  }
}