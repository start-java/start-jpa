# start-jpa

JPA - Java Persistence API

## JPA standard specification

- [JSR 338: Java Persistence 2.2](https://jcp.org/en/jsr/detail?id=338) - Maintenance Release 2017-08-04
- [JSR 338: Java Persistence 2.1](https://jcp.org/en/jsr/detail?id=338) - Final Release 2013-05-22
- [JSR 317: Java Persistence 2.0](https://jcp.org/en/jsr/detail?id=317) - Final Release 2009-12-10
- [JSR 220: Enterprise JavaBeans 3.0 (Java Persistence 1.0)](https://jcp.org/en/jsr/detail?id=220) - Final Release 2006-05-11

## JPA API

- 2017-08-21 javax.persistence:javax.persistence-api:2.2
- 2013-05-21 javax:javaee-api:7 (contain JPA2.1)
- 2007-07-24 javax.persistence:persistence-api:1.0.2
- 2018-03-03 org.hibernate.javax.persistence:hibernate-jpa-2.2-api:1.0.0.Beta2
- 2013-07-27 org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.0.Final
- 2011-06-15 org.hibernate.javax.persistence:hibernate-jpa-2.0-api:1.0.1.Final
- 2015-12-11 org.eclipse.persistence:javax.persistence:2.1.1
- 2015-08-28 org.datanucleus:javax.persistence:2.1.2

## JPA Implementations

- 2018-05-15 org.hibernate:hibernate-entitymanager:5.3.0.Final (JPA2.2) [Hibernate](http://hibernate.org/orm)
- 2017-08-22 org.eclipse.persistence:eclipselink:2.7.0 (JPA2.2) [EclipseLink](http://www.eclipse.org/eclipselink/#jpa)
- 2016-01-14 org.hibernate:hibernate-entitymanager:5.0.7.Final (JPA2.1) [Hibernate](http://hibernate.org/orm)
- 2015-12-22 org.eclipse.persistence:org.eclipse.persistence.jpa:2.6.2 (JPA2.1) [EclipseLink](http://www.eclipse.org/eclipselink/#jpa)
- 2015-10-11 org.datanucleus:datanucleus-jpa-query:4.0.5 (JPA2.1) [DataNucleus](http://datanucleus.org)
- 2018-06-09 org.apache.openjpa:openjpa:3.0.0 (JPA2.1) [OpenJPA](http://openjpa.apache.org)
- 2015-04-19 org.apache.openjpa:openjpa:2.4.0 (JPA2.0) [OpenJPA](http://openjpa.apache.org)
- 2013-08-28 org.batoo.jpa:batoo-jpa:2.0.1.2 (JPA2.0) [Batoo](http://batoo.org)
- 2015-12-18 org.springframework.data:spring-data-jpa:1.9.2.RELEASE [Spring Data JPA](http://projects.spring.io/spring-data-jpa)

> spring-boot will support JPA 2.2 after future release 2.1 version with Hibernate-5.3.

## JPA 2.2 main features

- Add ability to stream the result of a query execution
- Add @Repeatable
- Add support for basic Java 8 Date and Time types
- Allow AttributeConverters to support CDI injection
- updated persistence provider discovery mechanism for Java 9 Modules

> [jcp - Short changelog](https://jcp.org/aboutJava/communityprocess/maintenance/jsr338/ChangeLog-JPA-2.2-MR.txt)  
[What’s new in JPA 2.2](https://www.thoughts-on-java.org/whats-new-in-jpa-2-2/)  
[infoQ - JPA 2.2 带来一些备受期待的变更](http://www.infoq.com/cn/articles/JPA-2.2-Brings-Highly-Anticipated-Changes)

## JPA 2.1 main features

- Converters - allowing custom code conversions between database and object types.
- Criteria Update/Delete - allows bulk updates and deletes through the Criteria API.
- Stored Procedures - allows queries to be defined for database stored procedures.
- Schema Generation
- Entity Graphs - allow partial or specified fetching or merging of objects.
- JPQL/Criteria enhancements - arithmetic sub-queries, generic database functions, join ON clause, TREAT option.

## JPA 2.0 main features

- Expanded object-relational mapping functionality
- standardization of SQL Hints
- standardization of additional metadata to support DDL generation
- support for validation
- Shared object cache support.

## Related tutorial
- [JSR 338: Oracle official tutorial](https://docs.oracle.com/javaee/7/tutorial/partpersist.htm)

## Friendly link 
- [Wikipedia : Java Persistence API](https://en.wikipedia.org/wiki/Java_Persistence_API)
- [Thoughts On Java: JPA 2.1 – 12 features every developer should know](http://www.thoughts-on-java.org/jpa-21-overview)
- [IBM: Hibernate JPA 对象关系映射之关联关系映射策略](http://www.ibm.com/developerworks/cn/java/j-lo-jparelated)