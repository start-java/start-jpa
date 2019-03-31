package tech.simter.start.jpa.idwithconverter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.YearMonth;

/**
 * Test @Id with @Converter.
 *
 * @author RJ
 */
public class IdWithConverterTest {
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
    entityManagerFactory.close();
  }

  @Test
  public void test() {
    entityManager.getTransaction().begin();
    YearMonth id = YearMonth.of(2017, 12);

    // create and persist one
    Entity1 entity = new Entity1();
    entity.id = id;
    entityManager.persist(entity);

    // check it by load it form database
    entity = entityManager.createQuery("select e from Entity1 e where e.id = :id", Entity1.class)
      .setParameter("id", id)
      .getSingleResult();
    Assert.assertNotNull(entity);

    entityManager.getTransaction().commit();
  }
}