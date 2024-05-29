package com.sms;

import com.sms.entity.Student;
import com.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}


	@Autowired
	private StudentRepository studentRepository;


	@Override
	public void run(String... args) throws Exception {
//		Student st2 = new Student(2,"Ramesh", "Kumar","ramesh@gmail.com");
//		studentRepository.save(st2);
//
//		Student st3 = new Student(3,"Suraj", "Gupata","surajgupta@gmail.com");
//		studentRepository.save(st3);
	}

}
