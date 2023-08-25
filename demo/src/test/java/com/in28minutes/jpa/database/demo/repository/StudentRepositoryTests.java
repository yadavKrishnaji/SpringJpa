package com.in28minutes.jpa.database.demo.repository;

import com.in28minutes.jpa.database.demo.DemoApplication;
import com.in28minutes.jpa.database.demo.entity.Course;
import com.in28minutes.jpa.database.demo.oneToone.entity.Passport;
import com.in28minutes.jpa.database.demo.oneToone.entity.Student;
import com.in28minutes.jpa.database.demo.oneToone.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class StudentRepositoryTests {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EntityManager entityManager;

	//Seesion & Session Factory
	//EntityManager & Persistence Context
	//Transaction
	@Test
//	@Transactional // Persistance Context- all the entities you are creating is being stored
					// Note : if any of the operation got failed during the transaction all the operation got rolled back means nothing is persist into db
	public void someTest(){
		studentRepository.someOperationToUnderstandPersistenceContext();
	}

	@Test
	@Transactional
	public void retrieveStudentAndPassport() {
		Student student =  entityManager.find(Student.class,20001L);
		logger.info("student => {}", student);
		logger.info("passport=>{}", student.getPassport());
	}
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport =  entityManager.find(Passport.class,40001L);
		logger.info("passport => {}", passport);
		logger.info("Student=>{}", passport.getStudent());
	}


}
