package com.sms.controller;

import com.sms.entity.Student;
import com.sms.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class StudentController {

    private StudentService studentService;

    //ommit @Autowired as a single constructor don't need it
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //handler method to handle list of student and return model and view

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudent(Model model){
        Student student = new Student();

        model.addAttribute("student", student);

        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable(name = "id") long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")

    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model ){
        //get student from db by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());


        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
        public String deleteStudent(@PathVariable  Long id){
            studentService.deleteStudentById(id);
            return "redirect:/students";
        }
}

