package com.in28minutes.jpa.database.demo;

import com.in28minutes.jpa.database.demo.entity.Course;
import com.in28minutes.jpa.database.demo.oneToone.repository.StudentRepository;
import com.in28minutes.jpa.database.demo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(10001L);
//		logger.info("Course 10001 => {}",course);
//		//courseRepository.deleteById(10001L);
//		courseRepository.save(new Course("Microservice in 100 steps"));

		//courseRepository.playWithEntityManager();
		studentRepository.saveStudentWithPassport();

	}
}
