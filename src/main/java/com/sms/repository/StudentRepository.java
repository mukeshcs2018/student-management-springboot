package com.sms.repository;

import com.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


//don't need to add @Repository of class name SimpleJpaRepository is already have @Repository() in it and it implemented class JpaRepository
// sample for @Transactional()
public interface StudentRepository extends JpaRepository<Student, Long> {

}
