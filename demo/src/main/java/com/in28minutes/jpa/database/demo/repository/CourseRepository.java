package com.in28minutes.jpa.database.demo.repository;

import com.in28minutes.jpa.database.demo.entity.Course;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager manager;

    public Course findById(long id){
        return manager.find(Course.class,id);
    }

    public Course save(Course course){
        if(course.getId()==0L){
            manager.persist(course);
        }else{
            manager.merge(course);
        }
        return course;
    }
    public  void deleteById(long id){
        Course course = findById(id);
        manager.remove(course);
    }
    public void playWithEntityManager() {
        Course course1 = new Course("Web services in 100 steps");
        manager.persist(course1);
        Course course2 = findById(10001L);
        course2.setName("JPA in 50 steps-Updated");
        manager.flush();
    }
    public void playWithEntityManager2() {
        Course course1 = new Course("Web services in 100 steps");
        manager.persist(course1);
        Course course2 = new Course("React js in 100 steps");
        manager.persist(course2);
        manager.flush();

        course2.setName("React js in 100 steps-Updated");
        course1.setName("Web services in 100 steps-Updated");

        manager.refresh(course1);// wiil not persist updated value in course1 entity it will override what exist in db exactly
        manager.flush();
    }
    public void playWithEntityManager1(){
        Course course1 = new Course("Web services in 100 steps");
        manager.persist(course1);
        manager.flush();



        Course course2 = new Course("React js in 100 steps");
        manager.persist(course2);
        manager.flush();

        //manager.detach(course2); // note: ofter call this method nothing will persist ofter that related to course2 entity
        manager.clear();//ofter call this method nothing will persist ofter that clear every thing from enetity manager

        course2.setName("React js in 100 steps-Updated");
        manager.flush();

        course1.setName("Web services in 100 steps-Updated");
        manager.flush();

        logger.info("play with entity manager");
    }
}
