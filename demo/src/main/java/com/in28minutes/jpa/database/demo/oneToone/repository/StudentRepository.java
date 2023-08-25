package com.in28minutes.jpa.database.demo.oneToone.repository;

import com.in28minutes.jpa.database.demo.oneToone.entity.Passport;
import com.in28minutes.jpa.database.demo.oneToone.entity.Student;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager manager;

    public Student findById(long id){
        return manager.find(Student.class,id);
    }

    public Student save(Student student){
        if(student.getId()==0L){
            manager.persist(student);
        }else{
            manager.merge(student);
        }
        return student;
    }
    public  void deleteById(long id){
        Student student = findById(id);
        manager.remove(student);
    }
    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        manager.persist(passport);
        Student student = new Student("Mike");

        student.setPassport(passport);

        manager.persist(student);

        manager.flush();
    }

    public void someOperationToUnderstandPersistenceContext(){
        //Database Operation 1 - Retrieve Student
        Student student =  manager.find(Student.class,20001L);
        // Persistance Context(student)

        //Database Operation 2 - Retrieve Pasport
        Passport passport =  student.getPassport();
        // Persistance Context(student,passport)

        //Database Operation 3 - Update Student
        passport.setNumber("Z123457");
        // Persistance Context(student,passport++)

        //Database Operation 4 - Update Passport
        student.setName("Ranga - Updated");
        // Persistance Context(student++,passport++)
    }
}
