package com.in28minutes.jpa.database.demo.repository;

import com.in28minutes.jpa.database.demo.DemoApplication;
import com.in28minutes.jpa.database.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTests {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;
	@Test
	public void findById_basic() {
		Course course =  courseRepository.findById(10001L);
		assertEquals("JPA in 50 steps",course.getName());
	}
	@Test
	@DirtiesContext
	public void deleteById_basic(){
		courseRepository.deleteById(10002L);
		assertNull(courseRepository.findById(10002L));
	}
	@Test
	@DirtiesContext
	public void save_basic(){
		Course course =  courseRepository.findById(10001L);
		assertEquals("JPA in 50 steps",course.getName());

		course.setName("JPA in 50 steps - Updated");
		courseRepository.save(course);

		Course course1 =  courseRepository.findById(10001L);
		assertEquals("JPA in 50 steps - Updated",course1.getName());

	}
	@Test
	@DirtiesContext
	public void playWithEntityManager(){
		courseRepository.playWithEntityManager();

	}

}
