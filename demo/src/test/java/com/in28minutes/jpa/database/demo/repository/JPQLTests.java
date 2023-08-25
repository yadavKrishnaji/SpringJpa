package com.in28minutes.jpa.database.demo.repository;

import com.in28minutes.jpa.database.demo.DemoApplication;
import com.in28minutes.jpa.database.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class JPQLTests {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;
	@Test
	public void jpql_basic() {
		Query query = entityManager.createQuery("SELECT  C FROM Course C");
		List resultList = query.getResultList();
		logger.info("SELECT  C FROM COURSE C -> {}",resultList);
	}

	@Test
	public void jpql_named_query_basic() {
		Query query = entityManager.createNamedQuery("query_get_all_courses");
		List resultList = query.getResultList();
		logger.info("SELECT  C FROM COURSE C -> {}",resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = entityManager.createQuery("SELECT  C FROM Course C", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT  C FROM COURSE C -> {}",resultList);
	}
	@Test
	public void jpql_named_query_typed() {
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT  C FROM COURSE C -> {}",resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> query = entityManager.createQuery("SELECT  C FROM Course C where name like'%100 steps'", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT  C FROM Course C where name like'%100 Steps -> {}",resultList);
	}
	@Test
	public void jpql_namedQuery_where() {
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_100Steps_courses", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT  C FROM Course C where name like'%100 Steps -> {}",resultList);
	}
}
