package com.in28minutes.jpa.database.demo.oneToMany.repository;

import com.in28minutes.jpa.database.demo.oneToMany.entity.PassportOneToMany;
import com.in28minutes.jpa.database.demo.oneToMany.entity.StudentOneToMany;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepositoryOneToMany {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager manager;

    public StudentOneToMany findById(long id){
        return manager.find(StudentOneToMany.class,id);
    }

    public StudentOneToMany save(StudentOneToMany studentOneToMany){
        if(studentOneToMany.getId()==0L){
            manager.persist(studentOneToMany);
        }else{
            manager.merge(studentOneToMany);
        }
        return studentOneToMany;
    }
    public  void deleteById(long id){
        StudentOneToMany studentOneToMany = findById(id);
        manager.remove(studentOneToMany);
    }
    public void saveStudentWithPassport() {
        PassportOneToMany passportOneToMany = new PassportOneToMany("Z123456");
        manager.persist(passportOneToMany);
        StudentOneToMany studentOneToMany = new StudentOneToMany("Mike");

        studentOneToMany.setPassport(passportOneToMany);

        manager.persist(studentOneToMany);

        manager.flush();
    }

    public void someOperationToUnderstandPersistenceContext(){
        //Database Operation 1 - Retrieve Student
        StudentOneToMany studentOneToMany =  manager.find(StudentOneToMany.class,20001L);
        // Persistance Context(student)

        //Database Operation 2 - Retrieve Pasport
        PassportOneToMany passportOneToMany =  studentOneToMany.getPassport();
        // Persistance Context(student,passport)

        //Database Operation 3 - Update Student
        passportOneToMany.setNumber("Z123457");
        // Persistance Context(student,passport++)

        //Database Operation 4 - Update Passport
        studentOneToMany.setName("Ranga - Updated");
        // Persistance Context(student++,passport++)
    }
}
