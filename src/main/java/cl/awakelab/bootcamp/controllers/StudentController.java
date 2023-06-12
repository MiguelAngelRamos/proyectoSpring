package cl.awakelab.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.awakelab.bootcamp.entitys.Student;

@Controller
public class StudentController {
  
  // localhost:8080/students
  // http://localhost:8080/
  // http://localhost:8080
  @GetMapping({"/students", "/"})
  public String getAllStudents() {
    return "students";
  }
  // http://localhost:8080/students/new
  @GetMapping("/students/new")
  public String createStudentForm(Model model) {
    
    Student student = new Student();
    model.addAttribute("student", student);
    return "create-student";
  }
  
  //http://localhost:8080/students
  @PostMapping("/students")
  public String saveStudent(@ModelAttribute("student") Student student) {
    // Nosotros necesitamos llamar al Servicio y el servicio crea el recurso en la base de datos por medio de un DAO
    return "redirect:/students";
  }

}
