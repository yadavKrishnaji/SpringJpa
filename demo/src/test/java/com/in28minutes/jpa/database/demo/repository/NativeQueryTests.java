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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class NativeQueryTests {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;
	@Test
	public void native_queries_basic() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Course",Course.class);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM Course -> {}",resultList);
	}
	@Test
	public void native_queries_with_parameter() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Course Where id= ?",Course.class);
		query.setParameter(1,10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM Course Where id= ? -> {}",resultList);
	}
	@Test
	public void native_queries_with_named_parameter() {
		Query query = entityManager.createNativeQuery("SELECT * FROM Course Where id= :id",Course.class);
		query.setParameter("id",10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM Course Where id= :id -> {}",resultList);
	}
	@Test
	@Transactional
	public void native_queries_to_update(){
		Query query = entityManager.createNativeQuery("Update COURSE set last_updated_date=CURRENT_TIMESTAMP");
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("noOfRowsUpdated -> {} ",noOfRowsUpdated);
	}

}
