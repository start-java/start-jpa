package tech.simter.start.jpa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The JPA Reserved Word test.
 *
 * @author RJ
 */
public class ReservedWordTest {
  private EntityManagerFactory entityManagerFactory;
  private EntityManager entityManager;

  @Before
  public void setUp() {
    entityManagerFactory = Persistence.createEntityManagerFactory("my-jpa");
    entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    cleanData();
    entityManager.getTransaction().commit();
    entityManager.getTransaction().begin();
  }

  private void cleanData() {
    entityManager.createQuery("delete from Actor").executeUpdate();
  }

  @After
  public void destroy() {
    entityManager.getTransaction().commit();
    entityManager.close();

    // if set hibernate.hbm2ddl.auto=create-drop, raise drop need to invoke close method
    entityManagerFactory.close();
  }

  @Test
  public void testJPAReservedWord() {
    // add
    Actor actor = new Actor(ActorType.Group, "test");
    entityManager.persist(actor);
    Assert.assertNotNull(actor.getId());

    //==== empty is a jpa reserved word, need to set alias, or will raise this error:
    // java.lang.ClassCastException: org.hibernate.hql.internal.ast.tree.SqlNode cannot be cast to org.hibernate.hql.internal.ast.tree.FromReferenceNode
    //==== if a property name is also a database reserved word, need to set @Column(name="\"empty\"")

    // check
    Actor user = entityManager.createQuery("select a from Actor a where a.empty = :empty", Actor.class)
      .setParameter("empty", false)
      .getSingleResult();
    Assert.assertNotNull(user);
    Assert.assertEquals(actor, user);

    // update
    int c = entityManager.createQuery("update Actor a set a.empty = :empty where id = :id")
      .setParameter("empty", false)
      .setParameter("id", user.getId())
      .executeUpdate();
    Assert.assertEquals(1, c);
  }

  @Test
  public void testDBReservedWord() {
    String from = "fff";
    // add
    Actor actor = new Actor(ActorType.Group, "test");
    actor.setFrom(from);
    entityManager.persist(actor);
    Assert.assertNotNull(actor.getId());

    //==== from is a database reserved word, need to set @Column(name="\"from\"")

    // check
    Actor user = entityManager.createQuery("select a from Actor a where a.from = :from", Actor.class)
      .setParameter("from", from)
      .getSingleResult();
    Assert.assertNotNull(user);
    Assert.assertEquals(actor, user);

    // update
    int c = entityManager.createQuery("update Actor a set a.from = :from where id = :id")
      .setParameter("from", from)
      .setParameter("id", user.getId())
      .executeUpdate();
    Assert.assertEquals(1, c);
  }
}